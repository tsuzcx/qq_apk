package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ah.b;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import junit.framework.Assert;

public class FriendPreference
  extends Preference
  implements d.a
{
  private int cCg;
  private MMActivity cmc;
  private ad contact;
  private String gvd;
  private boolean lJS;
  private TextView pAD;
  private ImageView pAE;
  private ImageView pAF;
  private com.tencent.mm.plugin.account.friend.a.a pAG;
  private String pAH;
  private long pAI;
  private long pAJ;
  private TextView titleTv;
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(23622);
    this.cmc = ((MMActivity)paramContext);
    init();
    AppMethodBeat.o(23622);
  }
  
  public FriendPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(23623);
    setLayoutResource(2130970179);
    setWidgetLayoutResource(2130970254);
    init();
    AppMethodBeat.o(23623);
  }
  
  private void ccq()
  {
    AppMethodBeat.i(23627);
    if ((this.contact == null) || (!this.lJS))
    {
      ab.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.lJS);
      AppMethodBeat.o(23627);
      return;
    }
    this.cCg = 3;
    this.titleTv.setText(this.mContext.getString(2131300569));
    this.pAD.setText(bo.nullAsNil(this.contact.dqD));
    Object localObject1 = b.qN(this.pAJ);
    Object localObject5;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject5 = null;
      localObject4 = null;
    }
    label364:
    for (;;)
    {
      try
      {
        localInputStream = this.mContext.getResources().openRawResource(2131231226);
        localObject4 = localInputStream;
        localObject5 = localInputStream;
        Bitmap localBitmap = com.tencent.mm.compatible.g.a.decodeStream(localInputStream);
        localObject4 = localBitmap;
        localObject1 = localObject4;
        if (localInputStream == null) {}
      }
      catch (Exception localException4)
      {
        InputStream localInputStream;
        Object localObject2;
        localObject5 = localObject4;
        ab.printErrStackTrace("MicroMsg.FriendPreference", localException4, "", new Object[0]);
        if (localObject4 == null) {
          break label364;
        }
        try
        {
          ((InputStream)localObject4).close();
        }
        catch (Exception localException2)
        {
          ab.printErrStackTrace("MicroMsg.FriendPreference", localException2, "", new Object[0]);
        }
        continue;
      }
      finally
      {
        if (localObject5 == null) {
          continue;
        }
        try
        {
          localObject5.close();
          AppMethodBeat.o(23627);
          throw localObject3;
        }
        catch (Exception localException3)
        {
          ab.printErrStackTrace("MicroMsg.FriendPreference", localException3, "", new Object[0]);
          continue;
        }
      }
      try
      {
        localInputStream.close();
        localObject1 = localObject4;
      }
      catch (Exception localException1)
      {
        ab.printErrStackTrace("MicroMsg.FriendPreference", localException1, "", new Object[0]);
        localObject2 = localObject4;
        continue;
      }
      if (localObject1 != null)
      {
        localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject1, 48, 48, false);
        if (localObject4 != localObject1)
        {
          ab.i("MicroMsg.FriendPreference", "bitmap recycle %s", new Object[] { localObject1.toString() });
          ((Bitmap)localObject1).recycle();
        }
        localObject1 = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject4, true, 0.0F);
        this.pAE.setImageBitmap((Bitmap)localObject1);
      }
      aw.aaz();
      if (!c.isSDCardAvailable()) {
        this.pAE.setBackgroundDrawable(com.tencent.mm.cb.a.k(this.cmc, 2131231207));
      }
      AppMethodBeat.o(23627);
      return;
    }
  }
  
  private void ccr()
  {
    AppMethodBeat.i(23628);
    if ((this.contact == null) || (!this.lJS))
    {
      ab.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.lJS);
      AppMethodBeat.o(23628);
      return;
    }
    this.cCg = 2;
    this.titleTv.setText(this.mContext.getString(2131298621));
    Object localObject1 = bo.nullAsNil(this.pAH);
    localObject1 = (String)localObject1 + " " + new p(this.pAI).longValue();
    this.pAD.setText((CharSequence)localObject1);
    localObject1 = b.gB(this.pAI);
    Object localObject5;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject5 = null;
      localObject4 = null;
    }
    label389:
    for (;;)
    {
      try
      {
        localInputStream = this.mContext.getResources().openRawResource(2131231226);
        localObject4 = localInputStream;
        localObject5 = localInputStream;
        Bitmap localBitmap = com.tencent.mm.compatible.g.a.decodeStream(localInputStream);
        localObject4 = localBitmap;
        localObject1 = localObject4;
        if (localInputStream == null) {}
      }
      catch (Exception localException4)
      {
        InputStream localInputStream;
        Object localObject2;
        localObject5 = localObject4;
        ab.printErrStackTrace("MicroMsg.FriendPreference", localException4, "", new Object[0]);
        if (localObject4 == null) {
          break label389;
        }
        try
        {
          ((InputStream)localObject4).close();
        }
        catch (Exception localException2)
        {
          ab.printErrStackTrace("MicroMsg.FriendPreference", localException2, "", new Object[0]);
        }
        continue;
      }
      finally
      {
        if (localObject5 == null) {
          continue;
        }
        try
        {
          localObject5.close();
          AppMethodBeat.o(23628);
          throw localObject3;
        }
        catch (Exception localException3)
        {
          ab.printErrStackTrace("MicroMsg.FriendPreference", localException3, "", new Object[0]);
          continue;
        }
      }
      try
      {
        localInputStream.close();
        localObject1 = localObject4;
      }
      catch (Exception localException1)
      {
        ab.printErrStackTrace("MicroMsg.FriendPreference", localException1, "", new Object[0]);
        localObject2 = localObject4;
        continue;
      }
      if (localObject1 != null)
      {
        localObject4 = Bitmap.createScaledBitmap((Bitmap)localObject1, 48, 48, false);
        if (localObject4 != localObject1)
        {
          ab.i("MicroMsg.FriendPreference", "bitmap recycle %s", new Object[] { localObject1.toString() });
          ((Bitmap)localObject1).recycle();
        }
        localObject1 = com.tencent.mm.sdk.platformtools.d.a((Bitmap)localObject4, true, 0.0F);
        this.pAE.setImageBitmap((Bitmap)localObject1);
      }
      aw.aaz();
      if (!c.isSDCardAvailable()) {
        this.pAE.setBackgroundDrawable(com.tencent.mm.cb.a.k(this.cmc, 2131231207));
      }
      AppMethodBeat.o(23628);
      return;
    }
  }
  
  private void ccs()
  {
    AppMethodBeat.i(23629);
    if ((this.contact == null) || (!this.lJS))
    {
      ab.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.lJS);
      AppMethodBeat.o(23629);
      return;
    }
    if (this.pAG == null)
    {
      AppMethodBeat.o(23629);
      return;
    }
    this.cCg = 1;
    this.titleTv.setText(this.mContext.getString(2131298620));
    String str = bo.nullAsNil(this.pAG.apZ()) + " " + bo.nullAsNil(this.pAG.aqf()).replace(" ", "");
    this.pAD.setText(str);
    Bitmap localBitmap = l.b(this.pAG.apY(), this.mContext);
    if (localBitmap == null) {
      this.pAE.setImageDrawable(com.tencent.mm.cb.a.k(this.cmc, 2131231221));
    }
    for (;;)
    {
      aw.aaz();
      if (!c.YA().arr(this.pAG.getUsername())) {
        break;
      }
      this.pAF.setOnClickListener(new FriendPreference.1(this, str));
      AppMethodBeat.o(23629);
      return;
      localBitmap = com.tencent.mm.sdk.platformtools.d.a(Bitmap.createScaledBitmap(localBitmap, 48, 48, false), true, 0.0F);
      this.pAE.setImageBitmap(localBitmap);
    }
    this.pAF.setVisibility(4);
    AppMethodBeat.o(23629);
  }
  
  private void cct()
  {
    AppMethodBeat.i(23630);
    if ((this.contact == null) || (!this.lJS))
    {
      ab.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.lJS);
      AppMethodBeat.o(23630);
      return;
    }
    this.cCg = 3;
    this.titleTv.setText(this.mContext.getString(2131302380));
    this.pAD.setText(bo.nullAsNil(this.gvd));
    this.pAE.setVisibility(8);
    AppMethodBeat.o(23630);
  }
  
  private void init()
  {
    this.lJS = false;
    this.contact = null;
    this.pAG = null;
    this.pAH = "";
    this.pAI = 0L;
    this.pAJ = 0L;
    this.cCg = 0;
    this.gvd = "";
  }
  
  private void initView()
  {
    AppMethodBeat.i(23626);
    if ((this.contact == null) || (!this.lJS))
    {
      ab.d("MicroMsg.FriendPreference", "initView : contact = " + this.contact + " bindView = " + this.lJS);
      AppMethodBeat.o(23626);
      return;
    }
    if ((this.pAI != -1L) && (new p(this.pAI).longValue() > 0L))
    {
      setWidgetLayoutResource(2130970255);
      ccr();
      AppMethodBeat.o(23626);
      return;
    }
    if (this.pAG != null)
    {
      setWidgetLayoutResource(2130970246);
      ccs();
      AppMethodBeat.o(23626);
      return;
    }
    if (this.pAJ > 0L)
    {
      ccq();
      AppMethodBeat.o(23626);
      return;
    }
    if (!TextUtils.isEmpty(this.gvd))
    {
      cct();
      AppMethodBeat.o(23626);
      return;
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(23626);
  }
  
  private boolean q(String paramString, Bitmap paramBitmap)
  {
    AppMethodBeat.i(23631);
    if (paramBitmap != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localByteArrayOutputStream);
      boolean bool = l.a(paramString, this.mContext, localByteArrayOutputStream.toByteArray());
      AppMethodBeat.o(23631);
      return bool;
    }
    AppMethodBeat.o(23631);
    return false;
  }
  
  public final boolean bkb()
  {
    AppMethodBeat.i(23632);
    o.acQ().e(this);
    AppMethodBeat.o(23632);
    return true;
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(23625);
    this.titleTv = ((TextView)paramView.findViewById(2131820680));
    this.pAD = ((TextView)paramView.findViewById(2131821890));
    this.pAE = ((ImageView)paramView.findViewById(2131822243));
    this.pAF = ((ImageView)paramView.findViewById(2131826252));
    this.lJS = true;
    initView();
    super.onBindView(paramView);
    AppMethodBeat.o(23625);
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(23624);
    paramViewGroup = super.onCreateView(paramViewGroup);
    LayoutInflater localLayoutInflater = (LayoutInflater)this.mContext.getSystemService("layout_inflater");
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(2131820946);
    localViewGroup.removeAllViews();
    localLayoutInflater.inflate(2130970200, localViewGroup);
    AppMethodBeat.o(23624);
    return paramViewGroup;
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(23633);
    long l = b.qP(paramString);
    if ((l > 0L) && (this.pAI == l) && (b.b(paramString, false, -1) != null)) {
      initView();
    }
    if ((b.qO(paramString) == this.pAJ) && (b.b(paramString, false, -1) != null)) {
      initView();
    }
    AppMethodBeat.o(23633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.FriendPreference
 * JD-Core Version:    0.7.0.1
 */