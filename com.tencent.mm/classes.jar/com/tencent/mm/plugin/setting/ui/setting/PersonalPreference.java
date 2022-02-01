package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.setting.b.f;
import com.tencent.mm.plugin.setting.b.g;
import com.tencent.mm.plugin.setting.b.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.preference.Preference;

public class PersonalPreference
  extends Preference
{
  ImageView Aop;
  int Ppk;
  private View.OnClickListener Ppl;
  String avatar;
  private String hVP;
  private String kDc;
  private TextView lDe;
  Bitmap orY;
  private TextView userTV;
  private String username;
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.lDe = null;
    this.userTV = null;
    this.Aop = null;
    this.orY = null;
    this.Ppk = -1;
    this.avatar = null;
  }
  
  public PersonalPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(73903);
    this.lDe = null;
    this.userTV = null;
    this.Aop = null;
    this.orY = null;
    this.Ppk = -1;
    this.avatar = null;
    setLayoutResource(b.g.mm_preference);
    aBp(b.g.mm_preference_submenu);
    AppMethodBeat.o(73903);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(73905);
    if (this.Aop == null) {
      this.Aop = ((ImageView)paramView.findViewById(b.f.image_iv));
    }
    if (this.orY != null)
    {
      this.Aop.setImageBitmap(this.orY);
      this.Aop.setOnClickListener(this.Ppl);
      if ((this.lDe != null) && (this.hVP != null)) {
        this.lDe.setText(p.b(this.mContext, this.hVP, this.lDe.getTextSize()));
      }
      if (this.userTV != null) {
        if (!Util.isNullOrNil(this.kDc)) {
          break label232;
        }
      }
    }
    label232:
    for (String str = this.username;; str = this.kDc)
    {
      if ((Util.isNullOrNil(this.kDc)) && (au.bxb(this.username))) {
        this.userTV.setVisibility(8);
      }
      this.userTV.setText(this.mContext.getString(b.i.app_field_username) + str);
      super.onBindView(paramView);
      AppMethodBeat.o(73905);
      return;
      if (this.Ppk > 0)
      {
        this.Aop.setImageResource(this.Ppk);
        break;
      }
      if (this.avatar == null) {
        break;
      }
      a.b.g(this.Aop, this.avatar);
      break;
    }
  }
  
  public final View onCreateView(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(73904);
    paramViewGroup = super.onCreateView(paramViewGroup);
    ViewGroup localViewGroup = (ViewGroup)paramViewGroup.findViewById(b.f.content);
    localViewGroup.removeAllViews();
    View.inflate(this.mContext, b.g.mm_preference_content_personal, localViewGroup);
    AppMethodBeat.o(73904);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.setting.ui.setting.PersonalPreference
 * JD-Core Version:    0.7.0.1
 */