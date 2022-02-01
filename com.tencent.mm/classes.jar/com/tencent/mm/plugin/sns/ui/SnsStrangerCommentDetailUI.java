package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.model.ag;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.f;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SnsStrangerCommentDetailUI
  extends MMActivity
  implements b.b
{
  private static int Ajk = 4;
  private int AaL;
  private k.a Afy;
  private ListView Ajc;
  private SnsCommentFooter Ajd;
  private LinearLayout Aje;
  private List<View> Ajf;
  private a Ajg;
  private boolean Ajh;
  private boolean Aji;
  private am Ajj;
  private long dJc;
  private int dnh;
  private ImageView jdF;
  private TextView oHp;
  private View rXv;
  private String talker;
  private p yXF;
  private ay zPi;
  
  public SnsStrangerCommentDetailUI()
  {
    AppMethodBeat.i(99157);
    this.Ajh = false;
    this.AaL = -1;
    this.Aji = false;
    this.Afy = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(99146);
        ag.cVf().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(99145);
            ad.v("MicroMsg.SnsStrangerCommentDetailUI", "comment notify");
            SnsStrangerCommentDetailUI.d(SnsStrangerCommentDetailUI.this).a(null, null);
            if (SnsStrangerCommentDetailUI.e(SnsStrangerCommentDetailUI.this))
            {
              SnsStrangerCommentDetailUI.a(SnsStrangerCommentDetailUI.this, false);
              SnsStrangerCommentDetailUI localSnsStrangerCommentDetailUI = SnsStrangerCommentDetailUI.this;
              ag.cVf().postDelayed(new SnsStrangerCommentDetailUI.8(localSnsStrangerCommentDetailUI), 10L);
            }
            AppMethodBeat.o(99145);
          }
        });
        AppMethodBeat.o(99146);
      }
    };
    AppMethodBeat.o(99157);
  }
  
  private static void b(int paramInt, MMImageView paramMMImageView)
  {
    int j = 2131689584;
    AppMethodBeat.i(99164);
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      if (i != 0) {
        paramMMImageView.setImageResource(i);
      }
      AppMethodBeat.o(99164);
      return;
      i = 2131689564;
      continue;
      i = 2131689581;
      continue;
      i = 2131689562;
      continue;
      i = 2131230944;
      continue;
      i = 2131230944;
      continue;
      paramMMImageView.setImageDrawable(null);
      i = 0;
      continue;
      paramMMImageView.setImageDrawable(null);
      i = 0;
    }
  }
  
  private void ecD()
  {
    AppMethodBeat.i(99163);
    this.Aje.removeAllViews();
    int j = BackwardSupportUtil.b.g(this, Ajk);
    LinkedList localLinkedList = this.yXF.dYl().HAT.GaQ;
    this.Ajf = new ArrayList();
    int i = 0;
    if (i < localLinkedList.size())
    {
      MMImageView localMMImageView = new MMImageView(this);
      localMMImageView.setPadding(j, j, j, j);
      this.Aje.addView(localMMImageView, new ViewGroup.LayoutParams(-2, -2));
      Bitmap localBitmap = ag.dUb().a((byn)localLinkedList.get(i), localMMImageView, hashCode(), com.tencent.mm.storage.bj.ILV).ayF();
      if (localBitmap == null) {
        b(this.yXF.field_type, localMMImageView);
      }
      for (;;)
      {
        this.Ajf.add(localMMImageView);
        i += 1;
        break;
        localMMImageView.setImageBitmap(localBitmap);
      }
    }
    AppMethodBeat.o(99163);
  }
  
  public final void ays(String paramString)
  {
    AppMethodBeat.i(99165);
    ecD();
    AppMethodBeat.o(99165);
  }
  
  public final void bM(String paramString, boolean paramBoolean) {}
  
  public final void bN(String paramString, boolean paramBoolean) {}
  
  public final void dTb() {}
  
  public int getLayoutId()
  {
    return 2131495537;
  }
  
  public void initView()
  {
    AppMethodBeat.i(99162);
    this.Ajc = ((ListView)findViewById(2131296556));
    this.Ajd = ((SnsCommentFooter)findViewById(2131298521));
    this.rXv = View.inflate(this, 2131495593, null);
    this.Aje = ((LinearLayout)this.rXv.findViewById(2131296589));
    this.jdF = ((ImageView)this.rXv.findViewById(2131296533));
    this.oHp = ((TextView)this.rXv.findViewById(2131296595));
    a.b.w(this.jdF, this.yXF.field_userName);
    Object localObject = ((com.tencent.mm.plugin.messenger.a.b)g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(this.yXF.field_userName);
    this.oHp.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject, this.oHp.getTextSize()));
    ecD();
    int i = 0;
    while (i < this.Ajf.size())
    {
      localObject = new az();
      ((az)localObject).drH = this.yXF.dYK();
      ((az)localObject).index = i;
      ((az)localObject).Ady = this.Ajf;
      ((View)this.Ajf.get(i)).setTag(localObject);
      ((View)this.Ajf.get(i)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(99148);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((paramAnonymousView.getTag() instanceof az)) {
            SnsStrangerCommentDetailUI.f(SnsStrangerCommentDetailUI.this).w(paramAnonymousView, 2, 1);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(99148);
        }
      });
      i += 1;
    }
    this.Ajc.addHeaderView(this.rXv);
    this.Ajg = new a(this);
    this.Ajc.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99149);
        SnsStrangerCommentDetailUI.a(SnsStrangerCommentDetailUI.this, SnsStrangerCommentDetailUI.a(SnsStrangerCommentDetailUI.this).getBottom());
        ad.d("MicroMsg.SnsStrangerCommentDetailUI", "listOriginalBottom: " + SnsStrangerCommentDetailUI.g(SnsStrangerCommentDetailUI.this));
        AppMethodBeat.o(99149);
      }
    });
    this.Ajc.setAdapter(this.Ajg);
    this.Ajc.setOnScrollListener(new AbsListView.OnScrollListener()
    {
      public final void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt) {}
    });
    this.Ajd.setAfterEditAction(new Runnable()
    {
      int Acn = -1;
      int Aco = 10;
      
      public final void run()
      {
        AppMethodBeat.i(99140);
        if (!SnsStrangerCommentDetailUI.h(SnsStrangerCommentDetailUI.this)) {
          this.Aco = 10;
        }
        SnsStrangerCommentDetailUI.i(SnsStrangerCommentDetailUI.this);
        ad.e("MicroMsg.SnsStrangerCommentDetailUI", "list.bottom:" + SnsStrangerCommentDetailUI.a(SnsStrangerCommentDetailUI.this).getBottom() + " footer.top" + SnsStrangerCommentDetailUI.a(SnsStrangerCommentDetailUI.this).getTop());
        int i = SnsStrangerCommentDetailUI.j(SnsStrangerCommentDetailUI.this).getTop();
        int j = this.Aco;
        this.Aco = (j - 1);
        if ((j > 0) && ((this.Acn != i) || (SnsStrangerCommentDetailUI.a(SnsStrangerCommentDetailUI.this).getBottom() == SnsStrangerCommentDetailUI.g(SnsStrangerCommentDetailUI.this)))) {
          new ap().postDelayed(this, 30L);
        }
        this.Acn = i;
        BackwardSupportUtil.c.b(SnsStrangerCommentDetailUI.a(SnsStrangerCommentDetailUI.this), SnsStrangerCommentDetailUI.a(SnsStrangerCommentDetailUI.this).getCount() - 1);
        AppMethodBeat.o(99140);
      }
    });
    this.Ajd.ebR();
    this.Ajd.setOnCommentSendImp(new SnsCommentFooter.b()
    {
      public final void jU(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(99141);
        ad.v("MicroMsg.SnsStrangerCommentDetailUI", "comment send requested");
        SnsStrangerCommentDetailUI.a(SnsStrangerCommentDetailUI.this, true);
        SnsStrangerCommentDetailUI.a(SnsStrangerCommentDetailUI.this, SnsStrangerCommentDetailUI.k(SnsStrangerCommentDetailUI.this), paramAnonymousString1);
        AppMethodBeat.o(99141);
      }
    });
    this.Ajd.setCommentHint(getString(2131763952) + this.talker + getString(2131763775));
    setToTop(new SnsStrangerCommentDetailUI.1(this));
    setBackBtn(new SnsStrangerCommentDetailUI.4(this));
    addIconOptionMenu(0, 2131690603, new SnsStrangerCommentDetailUI.5(this));
    AppMethodBeat.o(99162);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(99166);
    ad.i("MicroMsg.SnsStrangerCommentDetailUI", "onAcvityResult requestCode:".concat(String.valueOf(paramInt1)));
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(99166);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(99166);
      return;
      if (paramInt2 == -1)
      {
        paramIntent = managedQuery(paramIntent.getData(), null, null, null, null);
        if (paramIntent.moveToFirst())
        {
          paramIntent = new Intent("android.intent.action.EDIT", Uri.parse("content://com.android.contacts/contacts/".concat(String.valueOf(paramIntent.getString(paramIntent.getColumnIndexOrThrow("_id"))))));
          paramIntent = new com.tencent.mm.hellhoundlib.b.a().bc(paramIntent);
          com.tencent.mm.hellhoundlib.a.a.a(this, paramIntent.ahp(), "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          startActivity((Intent)paramIntent.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/sns/ui/SnsStrangerCommentDetailUI", "onActivityResult", "(IILandroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(99158);
    super.onCreate(paramBundle);
    setMMTitle(2131763794);
    this.dJc = getIntent().getLongExtra("INTENT_SNSID", 0L);
    this.talker = getIntent().getStringExtra("INTENT_TALKER");
    this.yXF = ag.dUe().Ai(this.dJc);
    this.dnh = getIntent().getIntExtra("INTENT_SOURCE", -1);
    g.ajD();
    this.Ajj = ((l)g.ab(l.class)).azp().Bf(this.talker);
    if ((this.yXF == null) || (this.talker == null))
    {
      finish();
      AppMethodBeat.o(99158);
      return;
    }
    this.zPi = new ay(this);
    ag.dUj().add(this.Afy);
    initView();
    AppMethodBeat.o(99158);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(99161);
    ag.dUj().remove(this.Afy);
    ag.dUb().aD(this);
    if (this.Ajg != null) {
      this.Ajg.det();
    }
    super.onDestroy();
    AppMethodBeat.o(99161);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(99160);
    ag.dTZ().b(this);
    super.onPause();
    AppMethodBeat.o(99160);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(99159);
    ag.dTZ().a(this);
    super.onResume();
    AppMethodBeat.o(99159);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends r<j>
  {
    private Activity dsa;
    private View.OnClickListener oaE;
    
    public a(Activity paramActivity)
    {
      super(new j());
      AppMethodBeat.i(99152);
      this.oaE = new SnsStrangerCommentDetailUI.a.1(this);
      this.dsa = paramActivity;
      AppMethodBeat.o(99152);
    }
    
    public final void Zu()
    {
      AppMethodBeat.i(99154);
      com.tencent.mm.plugin.sns.storage.k localk = ag.dUj();
      String str = SnsStrangerCommentDetailUI.l(SnsStrangerCommentDetailUI.this);
      long l = SnsStrangerCommentDetailUI.m(SnsStrangerCommentDetailUI.this);
      str = com.tencent.mm.plugin.sns.storage.k.dYv() + " where talker = " + h.wo(str) + " and  snsID = " + l + " and ( type = 3 or type = 5 )";
      ad.v("MicroMsg.SnsCommentStorage", "comment sql:".concat(String.valueOf(str)));
      setCursor(localk.hHS.a(str, null, 0));
      AppMethodBeat.o(99154);
    }
    
    public final void Zv()
    {
      AppMethodBeat.i(99155);
      Zu();
      AppMethodBeat.o(99155);
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(99153);
      j localj;
      if (paramView == null)
      {
        paramViewGroup = new a();
        paramView = View.inflate(this.dsa, 2131495594, null);
        paramViewGroup.fOf = ((ImageView)paramView.findViewById(2131304955));
        paramViewGroup.hca = ((TextView)paramView.findViewById(2131304959));
        paramViewGroup.jhg = ((TextView)paramView.findViewById(2131304963));
        paramViewGroup.uuM = ((TextView)paramView.findViewById(2131304964));
        paramViewGroup.timeTv = ((TextView)paramView.findViewById(2131304965));
        paramViewGroup.Ajo = ((ImageView)paramView.findViewById(2131304960));
        paramView.setTag(paramViewGroup);
        localj = (j)getItem(paramInt);
      }
      Object localObject;
      for (;;)
      {
        try
        {
          localdfh = (dfh)new dfh().parseFrom(localj.field_curActionBuf);
          a.b.w(paramViewGroup.fOf, localdfh.Hgt);
          paramViewGroup.fOf.setTag(localdfh.Hgt);
          paramViewGroup.fOf.setOnClickListener(this.oaE);
          if (localdfh.HtE == null) {
            continue;
          }
          localObject = localdfh.HtE;
          paramViewGroup.jhg.setTag(localdfh.Hgt);
          SpannableString localSpannableString = com.tencent.mm.pluginsdk.ui.span.k.b(this.dsa, (CharSequence)localObject, paramViewGroup.jhg.getTextSize());
          localSpannableString.setSpan(new SnsStrangerCommentDetailUI.a.2(this, localdfh.Hgt), 0, ((String)localObject).length(), 33);
          paramViewGroup.jhg.setText(localSpannableString, TextView.BufferType.SPANNABLE);
          paramViewGroup.jhg.setOnTouchListener(new ae());
          if (localj.field_type != 3) {
            continue;
          }
          paramViewGroup.hca.setVisibility(0);
          paramViewGroup.Ajo.setVisibility(8);
          ad.v("MicroMsg.SnsStrangerCommentDetailUI", "source:" + localdfh.tRT + "  time:" + localdfh.CreateTime + " timeFormatted:" + bj.p(this.dsa, localdfh.CreateTime * 1000L));
          paramViewGroup.hca.setText(localdfh.hDa + " ");
          com.tencent.mm.pluginsdk.ui.span.k.n(paramViewGroup.hca, 2);
          paramViewGroup.hca.setVisibility(0);
          if (!u.aAm().equals(localdfh.Hgt)) {
            continue;
          }
          paramViewGroup.uuM.setVisibility(8);
          paramViewGroup.timeTv.setText(bj.p(this.dsa, localdfh.CreateTime * 1000L));
        }
        catch (Exception paramViewGroup)
        {
          dfh localdfh;
          ad.printErrStackTrace("MicroMsg.SnsStrangerCommentDetailUI", paramViewGroup, "", new Object[0]);
          continue;
          paramViewGroup.uuM.setVisibility(0);
          localObject = paramViewGroup.uuM;
          switch (localdfh.tRT)
          {
          }
        }
        AppMethodBeat.o(99153);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        localObject = ((j)this.JaC).field_talker;
        continue;
        paramViewGroup.hca.setVisibility(8);
        paramViewGroup.Ajo.setVisibility(0);
      }
      for (;;)
      {
        ((TextView)localObject).setText(SnsStrangerCommentDetailUI.this.getString(2131763832));
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cc.a.l(this.dsa, 2131233600), null);
        break;
        ((TextView)localObject).setText(SnsStrangerCommentDetailUI.this.getString(2131763831));
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cc.a.l(this.dsa, 2131233601), null);
        break;
        ((TextView)localObject).setText(SnsStrangerCommentDetailUI.this.getString(2131763829));
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cc.a.l(this.dsa, 2131233599), null);
        break;
        ((TextView)localObject).setText(SnsStrangerCommentDetailUI.this.getString(2131763828));
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cc.a.l(this.dsa, 2131233597), null);
        break;
        ((TextView)localObject).setText(SnsStrangerCommentDetailUI.this.getString(2131763830));
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(null, null, com.tencent.mm.cc.a.l(this.dsa, 2131233598), null);
        break;
      }
    }
    
    final class a
    {
      ImageView Ajo;
      ImageView fOf;
      TextView hca;
      TextView jhg;
      TextView timeTv;
      TextView uuM;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsStrangerCommentDetailUI
 * JD-Core Version:    0.7.0.1
 */