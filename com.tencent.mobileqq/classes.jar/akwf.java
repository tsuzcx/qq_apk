import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.ClipboardManager;
import android.widget.Toast;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserComponentsProvider.SwiftBrowserComponentContext;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserDebugHelper;

public class akwf
  implements DialogInterface.OnClickListener
{
  public akwf(SwiftBrowserDebugHelper paramSwiftBrowserDebugHelper, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ((ClipboardManager)this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserDebugHelper.a.a().getSystemService("clipboard")).setText(this.jdField_a_of_type_JavaLangString);
    Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqWebviewSwiftComponentSwiftBrowserDebugHelper.a.a().getApplicationContext(), "复制成功", 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     akwf
 * JD-Core Version:    0.7.0.1
 */