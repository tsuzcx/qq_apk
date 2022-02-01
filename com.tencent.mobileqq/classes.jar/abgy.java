import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.protofile.getappinfo.GetAppInfoProto.AndroidInfo;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class abgy
  extends Handler
{
  boolean jdField_a_of_type_Boolean;
  
  abgy(abgu paramabgu) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
            } while ((!(paramMessage.obj instanceof Bitmap)) || (this.jdField_a_of_type_Boolean));
            paramMessage = (Bitmap)paramMessage.obj;
          } while (paramMessage.isRecycled());
          paramMessage = nnw.a(paramMessage, (int)(34.0F * this.jdField_a_of_type_Abgu.jdField_a_of_type_Float));
        } while (this.jdField_a_of_type_Abgu.jdField_a_of_type_JavaLangRefWeakReference == null);
        localObject = (biod)this.jdField_a_of_type_Abgu.jdField_a_of_type_JavaLangRefWeakReference.get();
        if ((localObject != null) && ((localObject instanceof bits))) {
          ((bits)localObject).hideQQBrowserButton();
        }
        this.jdField_a_of_type_Abgu.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_Abgu.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramMessage);
        if ((this.jdField_a_of_type_Abgu.jdField_a_of_type_AndroidAppActivity instanceof binz))
        {
          paramMessage = ((binz)this.jdField_a_of_type_Abgu.jdField_a_of_type_AndroidAppActivity).a();
          if ((paramMessage != null) && (paramMessage.mUIStyleHandler.b != null))
          {
            paramMessage.mUIStyleHandler.b.findViewById(2131366315).setVisibility(8);
            paramMessage.mUIStyleHandler.b.findViewById(2131366316).setVisibility(0);
          }
        }
      } while (!QLog.isColorLevel());
      QLog.d(abgu.jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity VISIBLE -----------------------");
      return;
    } while ((!(paramMessage.obj instanceof Bitmap)) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Abgu.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse == null) || (this.jdField_a_of_type_Abgu.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_Abgu.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo.packName.get())));
    Object localObject = this.jdField_a_of_type_Abgu.jdField_a_of_type_ComTencentProtofileGetappinfoGetAppInfoProto$GetAppinfoResponse.androidInfo;
    if (bhny.a(this.jdField_a_of_type_Abgu.jdField_a_of_type_AndroidContentContext, ((GetAppInfoProto.AndroidInfo)localObject).packName.get())) {
      this.jdField_a_of_type_Abgu.b.setText(this.jdField_a_of_type_Abgu.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690060));
    }
    for (;;)
    {
      this.jdField_a_of_type_Abgu.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(this.jdField_a_of_type_Abgu.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690061), new Object[] { ((GetAppInfoProto.AndroidInfo)localObject).messagetail.get() }));
      paramMessage = (Bitmap)paramMessage.obj;
      if (paramMessage.isRecycled()) {
        break;
      }
      paramMessage = nnw.a(paramMessage, (int)(30.0F * this.jdField_a_of_type_Abgu.jdField_a_of_type_Float));
      this.jdField_a_of_type_Abgu.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_a_of_type_Abgu.c.setImageBitmap(paramMessage);
      bjvq.a().a(this.jdField_a_of_type_Abgu.n, String.valueOf(bhki.b(this.jdField_a_of_type_Abgu.jdField_a_of_type_Long)), "ANDROIDQQ.SHAREBAR", "100", false);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(abgu.jdField_a_of_type_JavaLangString, 2, "QQBrowserActivity APP_FLOATING_BAR VISIBLE -----------------------");
      return;
      this.jdField_a_of_type_Abgu.b.setText(this.jdField_a_of_type_Abgu.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690059));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     abgy
 * JD-Core Version:    0.7.0.1
 */