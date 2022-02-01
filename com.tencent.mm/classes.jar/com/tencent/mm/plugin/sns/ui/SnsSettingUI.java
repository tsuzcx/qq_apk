package com.tencent.mm.plugin.sns.ui;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.g;
import com.tencent.mm.plugin.sns.model.al;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.model.u;
import com.tencent.mm.plugin.sns.storage.SnsInfo;
import com.tencent.mm.plugin.sns.storage.ab;
import com.tencent.mm.plugin.sns.storage.r;
import com.tencent.mm.plugin.sns.storage.w;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.k.e;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.g.c;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SnsSettingUI
  extends MMActivity
{
  private a RwX;
  private String TAG;
  private LinkedList nlG;
  private ListView nlI;
  
  public SnsSettingUI()
  {
    AppMethodBeat.i(307672);
    this.TAG = "MicroMsg.SnsSettingUI";
    this.nlG = new LinkedList();
    this.RwX = new a();
    this.nlI = null;
    AppMethodBeat.o(307672);
  }
  
  private static int[] O(int... paramVarArgs)
  {
    int[] arrayOfInt = new int[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfInt[i] = paramVarArgs[i];
      i += 1;
    }
    return arrayOfInt;
  }
  
  private static List<String> R(String... paramVarArgs)
  {
    AppMethodBeat.i(307674);
    ArrayList localArrayList = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramVarArgs[i]);
      i += 1;
    }
    AppMethodBeat.o(307674);
    return localArrayList;
  }
  
  public int getLayoutId()
  {
    return b.g.sns_setting_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(307681);
    super.onCreate(paramBundle);
    if (!WeChatEnvironment.hasDebugger())
    {
      finish();
      AppMethodBeat.o(307681);
      return;
    }
    this.nlI = ((ListView)findViewById(b.f.sns_profile));
    this.nlI.setAdapter(this.RwX);
    this.nlG.add(new c("清空朋友圈漏读提醒", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(307607);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = al.hgN();
        try
        {
          y.deleteFile(paramAnonymousView.Qxx);
          aa.makeText(MMApplicationContext.getContext(), "好了", 1).show();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(307607);
          return;
        }
        catch (Exception paramAnonymousView)
        {
          for (;;)
          {
            Log.w("MicroMsg.SnsUnreadTipManager", "removeLastFault error:%s", new Object[] { paramAnonymousView.getMessage() });
          }
        }
      }
    }));
    this.nlG.add(new c("朋友圈缩略图下载", "进行套图下载", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308563);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        bh.Ruz = 1;
        k.c(SnsSettingUI.this, "已调整到套图下载，即刻生效！", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308563);
      }
    }));
    this.nlG.add(new c("朋友圈缩略图下载", "进行单图下载", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308578);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        bh.Ruz = 2;
        k.c(SnsSettingUI.this, "已调整到单图下载，即刻生效！", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308578);
      }
    }));
    this.nlG.add(new c("朋友圈缩略图下载", "目前状态", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308606);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        switch (bh.Ruz)
        {
        default: 
          if (bh.hoY()) {
            k.c(SnsSettingUI.this, "套图下载", "", true);
          }
          break;
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308606);
          return;
          k.c(SnsSettingUI.this, "套图下载", "", true);
          continue;
          k.c(SnsSettingUI.this, "单图下载", "", true);
          continue;
          k.c(SnsSettingUI.this, "单图下载", "", true);
        }
      }
    }));
    this.nlG.add(new c("朋友圈预加载cgi触发", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308604);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (com.tencent.mm.kernel.h.baz()) {
          com.tencent.mm.kernel.h.baD().mCm.a(new u(), 0);
        }
        k.c(SnsSettingUI.this, "妥了", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308604);
      }
    }));
    this.nlG.add(new b("朋友圈微商折叠辅助工具", at.a.adgE, R(new String[] { "关", "开" }), O(new int[] { 0, 1 })));
    this.nlG.add(new b("新版封面", at.a.adgF, R(new String[] { "默认", "开", "关" }), O(new int[] { 0, 1, 2 })));
    this.nlG.add(new b("封面finder立刻检查", at.a.adgG, R(new String[] { "默认", "开", "关" }), O(new int[] { 0, 1, 2 })));
    this.nlG.add(new b("封面展示debug信息", at.a.adgH, R(new String[] { "关", "开" }), O(new int[] { 0, 1 })));
    this.nlG.add(new c("本地设置默认封面", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308164);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.kernel.h.baF();
        paramAnonymousView = (String)com.tencent.mm.kernel.h.baE().ban().d(2, null);
        paramAnonymousView = al.hgG().aZM(paramAnonymousView);
        paramAnonymousView.field_type = 0;
        al.hgG().a(paramAnonymousView, true);
        k.c(SnsSettingUI.this, "妥了", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308164);
      }
    }));
    this.nlG.add(new c("本地设置打击封面", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308111);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        com.tencent.mm.kernel.h.baF();
        paramAnonymousView = (String)com.tencent.mm.kernel.h.baE().ban().d(2, null);
        paramAnonymousView = al.hgG().aZM(paramAnonymousView);
        paramAnonymousView.field_type = 5;
        al.hgG().a(paramAnonymousView, true);
        k.c(SnsSettingUI.this, "妥了", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308111);
      }
    }));
    this.nlG.add(new b("上传原始封面", at.a.adgI, R(new String[] { "关", "开" }), O(new int[] { 0, 1 })));
    this.nlG.add(new c("清空封面信息", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308115);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        paramAnonymousView = al.hgG();
        com.tencent.mm.kernel.h.baF();
        localObject = (String)com.tencent.mm.kernel.h.baE().ban().d(2, null);
        kotlin.g.b.s.u(localObject, "userName");
        Log.i(r.TAG, kotlin.g.b.s.X("removeSnsCover ", localObject));
        paramAnonymousView.delete((IAutoDBItem)paramAnonymousView.aZM((String)localObject), new String[0]);
        paramAnonymousView.QYJ.clear();
        k.c(SnsSettingUI.this, "妥了", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308115);
      }
    }));
    this.nlG.add(new c("清空重复url记录", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(308120);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        MultiProcessMMKV.getMMKV("SnsMMKV").encode("SnsMMKVUploadUrl", "");
        k.c(SnsSettingUI.this, "妥了", "", true);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(308120);
      }
    }));
    this.nlG.add(new c("随机插入sns db条数", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(307577);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new g.a(SnsSettingUI.this.getContext());
        paramAnonymousView.bf("要插入多少条").N(Boolean.TRUE);
        paramAnonymousView.c(new g.c()
        {
          public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            final int i = -1;
            AppMethodBeat.i(307908);
            SnsSettingUI.this.hideVKB();
            if (paramAnonymous2Boolean) {}
            try
            {
              int j = Util.getInt(paramAnonymous2String, -1);
              i = j;
            }
            catch (Exception paramAnonymous2String)
            {
              label31:
              break label31;
            }
            al.gHI().post(new Runnable()
            {
              public final void run()
              {
                Object localObject1 = null;
                AppMethodBeat.i(307911);
                final long l1;
                try
                {
                  l1 = MultiProcessMMKV.getMMKV("CleanExpireFileSystem").getLong("CleanExpireCurrentExpireTime", 0L);
                  Object localObject2 = al.hgB();
                  l1 /= 1000L;
                  l2 = System.currentTimeMillis() / 1000L;
                  Object localObject3 = "select *,rowid from SnsInfo  WHERE createTime < " + (l2 - l1) + " LIMIT 1";
                  localObject3 = ((w)localObject2).QYR.rawQuery((String)localObject3, null, 2);
                  localObject2 = new SnsInfo();
                  if (((Cursor)localObject3).moveToFirst())
                  {
                    ((SnsInfo)localObject2).convertFrom((Cursor)localObject3);
                    ((Cursor)localObject3).close();
                    localObject1 = localObject2;
                  }
                  while (localObject1 == null)
                  {
                    al.fAG().post(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(308290);
                        Toast.makeText(SnsSettingUI.this.getContext(), "原db为空，去朋友圈页面拉一下feed再继续！", 1).show();
                        AppMethodBeat.o(308290);
                      }
                    });
                    AppMethodBeat.o(307911);
                    return;
                    ((Cursor)localObject3).close();
                  }
                  l1 = al.hgB().hlb();
                }
                catch (Exception localException)
                {
                  Log.e(SnsSettingUI.a(SnsSettingUI.this), "test insert db error. %s", new Object[] { localException });
                  AppMethodBeat.o(307911);
                  return;
                }
                int i = 0;
                while (i < i)
                {
                  localException.field_snsId += 1L;
                  localException.field_createTime -= new Random().nextInt();
                  al.hgB().insertNotify(localException, false);
                  i += 1;
                }
                long l2 = al.hgB().hlb();
                al.fAG().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(308283);
                    Log.i(SnsSettingUI.a(SnsSettingUI.this), "cleanSnsTablesByTimeLimit finish add snsinfoStg, origin:%s, new:%s", new Object[] { Long.valueOf(l1), Long.valueOf(this.Rxe) });
                    Toast.makeText(SnsSettingUI.this.getContext(), String.format("insert snsinfo, origin:%s, new:%s", new Object[] { Long.valueOf(l1), Long.valueOf(this.Rxe) }), 1).show();
                    AppMethodBeat.o(308283);
                  }
                });
                AppMethodBeat.o(307911);
              }
            });
            AppMethodBeat.o(307908);
          }
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(307577);
      }
    }));
    this.nlG.add(new c("清理sns db", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(307578);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        paramAnonymousView = new g.a(SnsSettingUI.this.getContext());
        paramAnonymousView.bf("清理多少（分钟）以前的朋友圈").N(Boolean.TRUE);
        paramAnonymousView.c(new g.c()
        {
          public final void onDialogClick(boolean paramAnonymous2Boolean, String paramAnonymous2String)
          {
            int i = -1;
            AppMethodBeat.i(308391);
            SnsSettingUI.this.hideVKB();
            if (paramAnonymous2Boolean) {
              for (;;)
              {
                try
                {
                  int j = Util.getInt(paramAnonymous2String, -1);
                  i = j;
                }
                catch (Exception paramAnonymous2String)
                {
                  continue;
                }
                try
                {
                  al.hgW();
                  com.tencent.mm.plugin.sns.f.a.a(new CancellationSignal(), i);
                  AppMethodBeat.o(308391);
                  return;
                }
                catch (Exception paramAnonymous2String)
                {
                  Log.e(SnsSettingUI.a(SnsSettingUI.this), "cleanSnsTablesByTimeLimit error. %s", new Object[] { paramAnonymous2String });
                }
              }
            }
            AppMethodBeat.o(308391);
          }
        }).show();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(307578);
      }
    }));
    this.nlG.add(new c("删除sns db", "点我", new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(307584);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        al.hgW();
        com.tencent.mm.plugin.sns.f.a.hek();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(307584);
      }
    }));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(307582);
        SnsSettingUI.this.finish();
        AppMethodBeat.o(307582);
        return false;
      }
    });
    AppMethodBeat.o(307681);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    a() {}
    
    public final int getCount()
    {
      AppMethodBeat.i(308401);
      int i = SnsSettingUI.c(SnsSettingUI.this).size();
      AppMethodBeat.o(308401);
      return i;
    }
    
    public final Object getItem(int paramInt)
    {
      AppMethodBeat.i(308403);
      Object localObject = SnsSettingUI.c(SnsSettingUI.this).get(paramInt);
      AppMethodBeat.o(308403);
      return localObject;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public final View getView(int paramInt, final View paramView, final ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(308406);
      paramView = new TextView(SnsSettingUI.this);
      paramViewGroup = (SnsSettingUI.d)getItem(paramInt);
      paramView.setTag(paramViewGroup);
      paramView.setText(paramViewGroup.aUa() + "->:" + paramViewGroup.value());
      paramView.setGravity(17);
      paramView.setTextSize(1, 20.0F);
      paramView.setHeight(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 50));
      if (paramInt % 2 == 1) {
        paramView.setBackgroundColor(Color.parseColor("#e2efda"));
      }
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(308355);
          b localb = new b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/sns/ui/SnsSettingUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          paramViewGroup.di(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsSettingUI$ChoiceAdapter$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(308355);
        }
      });
      AppMethodBeat.o(308406);
      return paramView;
    }
  }
  
  final class b
    implements SnsSettingUI.d
  {
    List<String> FVP = null;
    String nlK = "";
    at.a nlL = null;
    Object nlN = null;
    
    public b(at.a parama, List<String> paramList, Object paramObject)
    {
      this.nlK = parama;
      this.nlL = paramList;
      this.FVP = paramObject;
      Object localObject;
      this.nlN = localObject;
    }
    
    public final String aUa()
    {
      return this.nlK;
    }
    
    public final void di(View paramView)
    {
      AppMethodBeat.i(308413);
      paramView = new LinkedList();
      LinkedList localLinkedList = new LinkedList();
      int i = 0;
      while (i < this.FVP.size())
      {
        paramView.add((String)this.FVP.get(i));
        localLinkedList.add(Integer.valueOf(i));
        i += 1;
      }
      k.a(SnsSettingUI.this, "", paramView, localLinkedList, "", new k.e()
      {
        public final void onClick(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(307768);
          try
          {
            if ((SnsSettingUI.b.this.nlN instanceof int[]))
            {
              paramAnonymousInt1 = ((int[])SnsSettingUI.b.this.nlN)[paramAnonymousInt1];
              if (com.tencent.mm.kernel.h.baz()) {
                com.tencent.mm.kernel.h.baE().ban().set(SnsSettingUI.b.this.nlL, Integer.valueOf(paramAnonymousInt1));
              }
            }
            for (;;)
            {
              SnsSettingUI.b(SnsSettingUI.this).notifyDataSetChanged();
              AppMethodBeat.o(307768);
              return;
              if ((SnsSettingUI.b.this.nlN instanceof long[]))
              {
                long l = ((long[])SnsSettingUI.b.this.nlN)[paramAnonymousInt1];
                if (com.tencent.mm.kernel.h.baz()) {
                  com.tencent.mm.kernel.h.baE().ban().set(SnsSettingUI.b.this.nlL, Long.valueOf(l));
                }
              }
            }
            return;
          }
          catch (Exception localException)
          {
            Log.printErrStackTrace(SnsSettingUI.a(SnsSettingUI.this), localException, "", new Object[0]);
            AppMethodBeat.o(307768);
          }
        }
      });
      AppMethodBeat.o(308413);
    }
    
    public final String value()
    {
      AppMethodBeat.i(308409);
      String str2 = "";
      String str1;
      if ((this.nlN instanceof int[]))
      {
        str1 = str2;
        if (com.tencent.mm.kernel.h.baz())
        {
          int j = com.tencent.mm.kernel.h.baE().ban().getInt(this.nlL, 0);
          str2 = (String)this.FVP.get(0);
          i = 0;
          str1 = str2;
          if (i < ((int[])this.nlN).length)
          {
            if ((j != ((int[])this.nlN)[i]) || (i >= this.FVP.size())) {
              break label126;
            }
            str1 = (String)this.FVP.get(i);
          }
        }
      }
      label126:
      do
      {
        do
        {
          AppMethodBeat.o(308409);
          return str1;
          i += 1;
          break;
          str1 = str2;
        } while (!(this.nlN instanceof long[]));
        str1 = str2;
      } while (!com.tencent.mm.kernel.h.baz());
      long l = com.tencent.mm.kernel.h.baE().ban().a(this.nlL, 0L);
      str2 = (String)this.FVP.get(0);
      int i = 0;
      for (;;)
      {
        str1 = str2;
        if (i >= ((long[])this.nlN).length) {
          break;
        }
        if ((l == ((long[])this.nlN)[i]) && (i < this.FVP.size()))
        {
          str1 = (String)this.FVP.get(i);
          break;
        }
        i += 1;
      }
    }
  }
  
  final class c
    implements SnsSettingUI.d
  {
    private View.OnClickListener Rxj = null;
    private String title = null;
    private String value = null;
    
    public c(String paramString1, String paramString2, View.OnClickListener paramOnClickListener)
    {
      this.title = paramString1;
      this.value = paramString2;
      this.Rxj = paramOnClickListener;
    }
    
    public final String aUa()
    {
      return this.title;
    }
    
    public final void di(View paramView)
    {
      AppMethodBeat.i(308416);
      this.Rxj.onClick(paramView);
      aa.makeText(MMApplicationContext.getContext(), "ClickItem Done", 1).show();
      AppMethodBeat.o(308416);
    }
    
    public final String value()
    {
      return this.value;
    }
  }
  
  static abstract interface d
  {
    public abstract String aUa();
    
    public abstract void di(View paramView);
    
    public abstract String value();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsSettingUI
 * JD-Core Version:    0.7.0.1
 */