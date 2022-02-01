import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.activity.recent.cur.DragTextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONObject;

public class aaci
  extends RecyclerView.ViewHolder
{
  private algy jdField_a_of_type_Algy;
  private aljh jdField_a_of_type_Aljh;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private DragTextView jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView;
  private HashMap<String, Bitmap> jdField_a_of_type_JavaUtilHashMap;
  public uon a;
  private boolean jdField_a_of_type_Boolean;
  
  public aaci(View paramView, algy paramalgy, HashMap<String, Bitmap> paramHashMap, DragFrameLayout paramDragFrameLayout)
  {
    super(paramView);
    this.jdField_a_of_type_Algy = paramalgy;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
    this.jdField_a_of_type_Aljh = paramDragFrameLayout;
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131377423));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377428));
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView = ((DragTextView)paramView.findViewById(2131377431));
  }
  
  private void a(View paramView, uon paramuon)
  {
    if (TextUtils.equals(paramuon.jdField_a_of_type_JavaLangString, ayoq.jdField_a_of_type_JavaLangString))
    {
      ayos.a(paramView.getContext(), paramuon.jdField_a_of_type_JavaLangString, 1);
      return;
    }
    b(paramView, paramuon);
  }
  
  private boolean a(uon paramuon1, uon paramuon2)
  {
    if ((paramuon1 != null) && (paramuon2 != null)) {
      if ((!paramuon1.jdField_a_of_type_JavaLangString.equals(paramuon2.jdField_a_of_type_JavaLangString)) || (paramuon1.b != paramuon2.b) || (paramuon1.jdField_a_of_type_Int != paramuon2.jdField_a_of_type_Int) || (!paramuon1.c.equals(paramuon2.c))) {
        break label88;
      }
    }
    label88:
    for (boolean bool = true;; bool = false)
    {
      QLog.d(ServiceFolderFollowPBHeadView.a(), 4, "isSameServiceData:" + bool);
      return false;
    }
  }
  
  private void b(View paramView, uon paramuon)
  {
    Intent localIntent = new Intent(paramView.getContext(), ChatActivity.class);
    localIntent.putExtra("uintype", 1008);
    localIntent.putExtra("uin", paramuon.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uinname", paramuon.c);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.putExtra("red_hot_count", paramuon.b);
    localIntent.putExtra("INTENT_KEY_FROM", 2);
    paramView.getContext().startActivity(localIntent);
  }
  
  @RequiresApi(api=8)
  public void a(ImageView paramImageView, String paramString)
  {
    Bitmap localBitmap = (Bitmap)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    if (localBitmap == null) {
      paramImageView.setImageDrawable(this.jdField_a_of_type_Algy.a(1008, paramString));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        paramImageView.setColorFilter(1711276032);
      }
      return;
      paramImageView.setImageBitmap(localBitmap);
    }
  }
  
  public void a(uon paramuon, int paramInt)
  {
    if ((paramuon == null) || (a(this.jdField_a_of_type_Uon, paramuon))) {
      return;
    }
    this.jdField_a_of_type_Uon = paramuon;
    this.itemView.setTag(this.jdField_a_of_type_Uon);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377425, this.jdField_a_of_type_Uon);
    this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setTag(2131377423, Integer.valueOf(paramInt));
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramuon.c);
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-5723992);
    }
    a(this.jdField_a_of_type_ComTencentImageURLImageView, paramuon.jdField_a_of_type_JavaLangString);
    int j = paramuon.b;
    int i = 0;
    int k = 0;
    int m = paramuon.jdField_a_of_type_Int;
    Object localObject = paramuon.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localObject != null)
    {
      localObject = apau.a(j + "", ((MessageRecord)localObject).msgseq + "", ((MessageRecord)localObject).msgBackupMsgRandom + "");
      if (j <= 0) {
        break label491;
      }
      if (m != 0) {
        break label421;
      }
      i = 0;
      k = 0;
      j = 0;
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, this.itemView);
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
    }
    for (;;)
    {
      blas.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView, i, j, k, 99, null);
      String str2 = "";
      String str1 = str2;
      if (paramuon.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null)
      {
        str1 = str2;
        if (paramuon.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject != null) {
          str1 = paramuon.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "");
        }
      }
      this.itemView.setOnClickListener(new aacj(this, paramuon, paramInt, str1, (String)localObject));
      apau.a(null, paramuon.jdField_a_of_type_JavaLangString, paramuon.jdField_a_of_type_Int, paramuon.b, paramuon.jdField_a_of_type_JavaLangCharSequence.toString(), str1, (String)localObject, paramInt + "");
      aanb.a(paramuon.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_exp", 0, 0, new String[] { "", "", paramuon.c, paramuon.jdField_a_of_type_JavaLangCharSequence.toString() });
      return;
      localObject = "";
      break;
      label421:
      if (m == 2)
      {
        i = 1;
        k = 0;
        j = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(-1, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(null);
      }
      else
      {
        i = 3;
        k = 2130850431;
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setDragViewType(0, this.itemView);
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentCurDragTextView.setOnModeChangeListener(this.jdField_a_of_type_Aljh);
        continue;
        label491:
        j = 0;
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aaci
 * JD-Core Version:    0.7.0.1
 */