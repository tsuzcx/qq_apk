package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CUploadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CUploadResult;
import com.tencent.mars.cdn.CdnLogic.UploadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.b.n;
import com.tencent.mm.kernel.c;
import com.tencent.mm.plugin.qqmail.d.aj;
import com.tencent.mm.plugin.qqmail.d.ap;
import com.tencent.mm.plugin.qqmail.e.c;
import com.tencent.mm.plugin.qqmail.e.d;
import com.tencent.mm.plugin.qqmail.e.e;
import com.tencent.mm.plugin.qqmail.e.f;
import com.tencent.mm.plugin.qqmail.e.g;
import com.tencent.mm.plugin.qqmail.e.h;
import com.tencent.mm.plugin.qqmail.e.i;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class b
  implements CdnLogic.UploadCallback, i
{
  private ImageView HoA;
  private TextView Hoz;
  private ComposeUI HpT;
  Map<String, aj> HpU;
  private Map<String, com.tencent.mm.plugin.qqmail.e.a> HpV;
  private Map<String, String> HpW;
  b HpX;
  private View.OnClickListener HpY;
  private ViewGroup ybY;
  
  private b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(123021);
    this.HpU = new HashMap();
    this.HpV = new HashMap();
    this.HpW = new HashMap();
    this.HpX = null;
    this.HpY = null;
    this.HpT = paramComposeUI;
    this.ybY = paramViewGroup;
    this.HpY = null;
    this.Hoz = paramTextView;
    this.HoA = paramImageView;
    fsV();
    com.tencent.mm.kernel.h.aHF().kcd.a(11665, this);
    AppMethodBeat.o(123021);
  }
  
  public b(ComposeUI paramComposeUI, TextView paramTextView, ImageView paramImageView, ViewGroup paramViewGroup, byte paramByte)
  {
    this(paramComposeUI, paramTextView, paramImageView, paramViewGroup);
  }
  
  private void b(aj paramaj)
  {
    AppMethodBeat.i(123034);
    int i = Math.abs(paramaj.path.hashCode() / 2);
    Object localObject = (LinearLayout)this.ybY.findViewById(i);
    if (localObject == null)
    {
      AppMethodBeat.o(123034);
      return;
    }
    localObject = (a)((LinearLayout)localObject).getTag();
    Log.i("MicroMsg.Mail.FileUploadHelper", "show upload status %d", new Object[] { Integer.valueOf(paramaj.state) });
    switch (paramaj.state)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).mYd.setTextColor(this.HpT.getResources().getColor(e.c.normal_text_color));
      ((a)localObject).uploadingPB.setVisibility(0);
      ((a)localObject).Hqg.setVisibility(8);
      ((a)localObject).Hqh.setVisibility(8);
      ((a)localObject).Hqi.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).mYd.setTextColor(this.HpT.getResources().getColor(e.c.normal_text_color));
      ((a)localObject).uploadingPB.setVisibility(8);
      ((a)localObject).Hqg.setVisibility(8);
      ((a)localObject).Hqh.setVisibility(8);
      ((a)localObject).Hqi.setVisibility(0);
      AppMethodBeat.o(123034);
      return;
      ((a)localObject).mYd.setTextColor(com.tencent.mm.ci.a.w(this.HpT, e.c.lightgrey));
      ((a)localObject).uploadingPB.setVisibility(8);
      ((a)localObject).Hqg.setVisibility(0);
      ((a)localObject).Hqh.setVisibility(0);
      ((a)localObject).Hqi.setVisibility(0);
    }
  }
  
  final void a(final aj paramaj)
  {
    AppMethodBeat.i(123025);
    final LinearLayout localLinearLayout = (LinearLayout)((ViewGroup)View.inflate(this.HpT, e.f.qqmail_comm_widget, null)).findViewById(e.e.plugin_qqmail_compose_attach_item_ll);
    ImageView localImageView1 = (ImageView)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_item_icon_iv);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_item_name_tv);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_item_size_tv);
    ProgressBar localProgressBar = (ProgressBar)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_item_uploading_pb);
    TextView localTextView3 = (TextView)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_upload_failed_tv);
    ImageView localImageView2 = (ImageView)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_item_reupload_iv);
    ImageView localImageView3 = (ImageView)localLinearLayout.findViewById(e.e.plugin_qqmail_compose_attach_item_delete_iv);
    ((ViewGroup)localLinearLayout.getParent()).removeView(localLinearLayout);
    localImageView1.setImageResource(FileExplorerUI.brL(paramaj.name));
    localTextView1.setText(paramaj.name);
    localTextView2.setText(Util.getSizeKB(paramaj.size));
    a locala = new a((byte)0);
    locala.qps = localImageView1;
    locala.mYd = localTextView1;
    locala.HpD = localTextView2;
    locala.uploadingPB = localProgressBar;
    locala.Hqg = localTextView3;
    locala.Hqh = localImageView2;
    locala.Hqi = localImageView3;
    localLinearLayout.setTag(locala);
    localLinearLayout.setId(Math.abs(paramaj.path.hashCode() / 2));
    if (this.HpY != null) {
      localLinearLayout.setOnClickListener(this.HpY);
    }
    this.ybY.addView(localLinearLayout);
    fsV();
    localLinearLayout.setOnClickListener(new b.1(this, localImageView2));
    localImageView2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123009);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramaj.yjR = b.a(b.this, paramaj.path);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123009);
      }
    });
    localImageView3.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(123011);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        com.tencent.mm.ui.base.h.a(b.a(b.this), e.i.plugin_qqmail_attachment_delete_confirm, e.i.app_tip, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
          {
            AppMethodBeat.i(123010);
            if ((b.3.this.Hqb.state == 0) || (b.3.this.Hqb.state == 1)) {
              b.a(b.this, b.3.this.Hqb);
            }
            b.b(b.this).remove(b.3.this.Hqb.path);
            b.c(b.this).remove(b.3.this.Hqb.path);
            b.d(b.this).removeView(b.3.this.Hqc);
            b.this.fsV();
            AppMethodBeat.o(123010);
          }
        }, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/FileUploadHelper$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(123011);
      }
    });
    this.ybY.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(123012);
        b.b(b.this, paramaj);
        AppMethodBeat.o(123012);
      }
    });
    if (paramaj.state == 0) {
      paramaj.yjR = aVk(paramaj.path);
    }
    AppMethodBeat.o(123025);
  }
  
  final long aVk(String paramString)
  {
    AppMethodBeat.i(123029);
    try
    {
      Object localObject1 = new com.tencent.mm.vfs.q(paramString);
      Log.i("MicroMsg.Mail.FileUploadHelper", "doNormalUpload %s", new Object[] { paramString, ((com.tencent.mm.vfs.q)localObject1).getName() });
      Object localObject2 = u.aY(paramString, 0, (int)((com.tencent.mm.vfs.q)localObject1).length());
      String str = n.bytesToHex(MessageDigest.getInstance("SHA1").digest((byte[])localObject2));
      localObject2 = MD5Util.getMD5String((byte[])localObject2);
      localObject1 = new com.tencent.mm.plugin.qqmail.e.a(paramString, (int)((com.tencent.mm.vfs.q)localObject1).length(), str, (String)localObject2);
      com.tencent.mm.kernel.h.aGY().a((com.tencent.mm.an.q)localObject1, 0);
      this.HpV.put(paramString, localObject1);
      long l = System.currentTimeMillis();
      AppMethodBeat.o(123029);
      return l;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.Mail.FileUploadHelper", paramString, "", new Object[0]);
      }
    }
  }
  
  public final boolean aaL(String paramString)
  {
    AppMethodBeat.i(123024);
    boolean bool = this.HpU.containsKey(paramString);
    AppMethodBeat.o(123024);
    return bool;
  }
  
  public final LinkedList<aj> fsS()
  {
    AppMethodBeat.i(123027);
    LinkedList localLinkedList = new LinkedList();
    Iterator localIterator = this.HpU.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localLinkedList.add(this.HpU.get(str));
    }
    AppMethodBeat.o(123027);
    return localLinkedList;
  }
  
  public final void fsT()
  {
    AppMethodBeat.i(123028);
    Iterator localIterator = this.HpU.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aj)this.HpU.get(localObject);
      if (((aj)localObject).state != 2)
      {
        com.tencent.mm.plugin.qqmail.e.a locala = (com.tencent.mm.plugin.qqmail.e.a)this.HpV.get(((aj)localObject).path);
        if (locala != null)
        {
          com.tencent.mm.kernel.h.aHF().kcd.a(locala);
          ((aj)localObject).state = 3;
          b((aj)localObject);
          this.HpV.remove(((aj)localObject).path);
        }
      }
    }
    AppMethodBeat.o(123028);
  }
  
  public final boolean fsU()
  {
    AppMethodBeat.i(123031);
    Iterator localIterator = this.HpU.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      localObject = (aj)this.HpU.get(localObject);
      if ((((aj)localObject).state != 2) && (((aj)localObject).state != 3))
      {
        AppMethodBeat.o(123031);
        return false;
      }
    }
    AppMethodBeat.o(123031);
    return true;
  }
  
  public final void fsV()
  {
    AppMethodBeat.i(123032);
    int j;
    int i;
    if (this.HpU.size() == 0)
    {
      this.Hoz.setText(this.HpT.getString(e.i.plugin_qqmail_composeui_attach) + " " + this.HpT.getString(e.i.plugin_qqmail_composeui_attach_hint));
      this.HoA.setImageResource(e.h.qqmail_attach_icon_normal);
      ((View)this.ybY.getParent()).setVisibility(8);
      j = this.ybY.getChildCount();
      i = 0;
      label102:
      if (i >= j) {
        break label311;
      }
      if (j != 1) {
        break label245;
      }
      this.ybY.getChildAt(i).setBackgroundResource(e.d.mail_attach_list_item);
    }
    for (;;)
    {
      i += 1;
      break label102;
      this.Hoz.setText(this.HpT.getString(e.i.plugin_qqmail_composeui_attach) + this.HpT.getResources().getQuantityString(e.g.plugin_qqmail_composeui_attach_summary, this.HpU.size(), new Object[] { Integer.valueOf(this.HpU.size()), Util.getSizeKB(getTotalSize()) }));
      this.HoA.setImageResource(e.h.qqmail_attach_icon_pressed);
      ((View)this.ybY.getParent()).setVisibility(0);
      break;
      label245:
      if (i == 0) {
        this.ybY.getChildAt(i).setBackgroundResource(e.d.mail_attach_list_item1);
      } else if ((i > 0) && (i < j - 1)) {
        this.ybY.getChildAt(i).setBackgroundResource(e.d.mail_attach_list_item2);
      } else {
        this.ybY.getChildAt(i).setBackgroundResource(e.d.mail_attach_list_item3);
      }
    }
    label311:
    AppMethodBeat.o(123032);
  }
  
  public final void gB(List<aj> paramList)
  {
    AppMethodBeat.i(251150);
    if (paramList == null)
    {
      AppMethodBeat.o(251150);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      aj localaj = (aj)paramList.next();
      this.HpU.put(localaj.path, localaj);
      a(localaj);
    }
    AppMethodBeat.o(251150);
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(123033);
    Iterator localIterator = this.HpU.keySet().iterator();
    String str;
    long l;
    for (int i = 0; localIterator.hasNext(); i = (int)(((aj)this.HpU.get(str)).size + l))
    {
      str = (String)localIterator.next();
      l = i;
    }
    AppMethodBeat.o(123033);
    return i;
  }
  
  public final void onC2CUploadCompleted(String paramString, final CdnLogic.C2CUploadResult paramC2CUploadResult)
  {
    AppMethodBeat.i(251158);
    Log.i("MicroMsg.Mail.FileUploadHelper", "onC2CUploadCompleted %s", new Object[] { paramString });
    if (this.HpW.containsKey(paramString)) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(249649);
          if (this.Hqe != null)
          {
            if (paramC2CUploadResult.errorCode == 0) {
              break label47;
            }
            this.Hqe.state = 3;
          }
          for (;;)
          {
            b.b(b.this, this.Hqe);
            AppMethodBeat.o(249649);
            return;
            label47:
            this.Hqe.state = 2;
            b.e(b.this);
          }
        }
      });
    }
    AppMethodBeat.o(251158);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(123035);
    if (paramq.getType() == 11665)
    {
      String str = ((com.tencent.mm.plugin.qqmail.e.a)paramq).filePath;
      Log.i("MicroMsg.Mail.FileUploadHelper", "errType %d, errCode %d, errMsg %s, filePath %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, str });
      paramString = (aj)this.HpU.get(str);
      this.HpV.remove(str);
      if (paramString != null)
      {
        if ((paramInt1 != 0) || (paramInt2 != 0))
        {
          paramString.state = 3;
          b(paramString);
          AppMethodBeat.o(123035);
          return;
        }
        CdnLogic.C2CUploadRequest localC2CUploadRequest = new CdnLogic.C2CUploadRequest();
        localC2CUploadRequest.fileKey = ((com.tencent.mm.plugin.qqmail.e.a)paramq).HnQ;
        localC2CUploadRequest.setFilePath(str);
        localC2CUploadRequest.forwardFileid = ((ap)d.c.b(((com.tencent.mm.plugin.qqmail.e.a)paramq).lKU.lBS)).Hny;
        localC2CUploadRequest.host = ((ap)d.c.b(((com.tencent.mm.plugin.qqmail.e.a)paramq).lKU.lBS)).Hnx;
        this.HpW.put(localC2CUploadRequest.fileKey, str);
        paramString.state = 1;
        paramString.svrId = ((ap)d.c.b(((com.tencent.mm.plugin.qqmail.e.a)paramq).lKU.lBS)).fileid;
        b(paramString);
        CdnLogic.startFtnUpload(localC2CUploadRequest, this);
      }
    }
    AppMethodBeat.o(123035);
  }
  
  public final void onUploadProgressChanged(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(251157);
    Log.i("MicroMsg.Mail.FileUploadHelper", "onUploadProgressChanged fileKey:%s finish:%d total:%d", new Object[] { paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(251157);
  }
  
  final class a
  {
    TextView HpD;
    TextView Hqg;
    ImageView Hqh;
    ImageView Hqi;
    TextView mYd;
    ImageView qps;
    ProgressBar uploadingPB;
    
    private a() {}
  }
  
  public static abstract interface b
  {
    public abstract void fsJ();
    
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.b
 * JD-Core Version:    0.7.0.1
 */