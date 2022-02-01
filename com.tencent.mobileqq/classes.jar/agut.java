import android.text.Editable;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class agut
{
  private int jdField_a_of_type_Int;
  private Editable jdField_a_of_type_AndroidTextEditable;
  private int jdField_b_of_type_Int;
  private Editable jdField_b_of_type_AndroidTextEditable;
  private int jdField_c_of_type_Int;
  private Editable jdField_c_of_type_AndroidTextEditable;
  private int jdField_d_of_type_Int = -1;
  private Editable jdField_d_of_type_AndroidTextEditable;
  
  agut(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidTextEditable = new SpannableStringBuilder(paramCharSequence);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_c_of_type_Int = paramInt3;
    try
    {
      this.jdField_d_of_type_Int = a();
      return;
    }
    catch (Throwable paramCharSequence)
    {
      paramCharSequence.printStackTrace();
    }
  }
  
  int a()
  {
    if (this.jdField_a_of_type_AndroidTextEditable.length() <= 0) {
      return -1;
    }
    Object localObject;
    if ((this.jdField_b_of_type_Int > 0) && (this.jdField_c_of_type_Int > 0))
    {
      this.jdField_c_of_type_AndroidTextEditable = ((Editable)this.jdField_a_of_type_AndroidTextEditable.subSequence(0, this.jdField_a_of_type_Int));
      this.jdField_d_of_type_AndroidTextEditable = ((Editable)this.jdField_a_of_type_AndroidTextEditable.subSequence(this.jdField_a_of_type_Int + this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidTextEditable.length()));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("[mix]handle replace prefix: ");
        if (TextUtils.isEmpty(this.jdField_c_of_type_AndroidTextEditable)) {
          break label215;
        }
        ((StringBuilder)localObject).append(" prefix tail: ").append(this.jdField_c_of_type_AndroidTextEditable.charAt(this.jdField_c_of_type_AndroidTextEditable.length() - 1));
        ((StringBuilder)localObject).append(" suffix: ");
        if (TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextEditable)) {
          break label225;
        }
        ((StringBuilder)localObject).append(" suffix head: ").append(this.jdField_d_of_type_AndroidTextEditable.charAt(0));
      }
      for (;;)
      {
        QLog.d("FullScreenInputHelper", 2, new Object[] { localObject });
        if ((!TextUtils.isEmpty(this.jdField_c_of_type_AndroidTextEditable)) || (!aguk.a(this.jdField_d_of_type_AndroidTextEditable, "￼"))) {
          break label235;
        }
        return 12;
        label215:
        ((StringBuilder)localObject).append("null");
        break;
        label225:
        ((StringBuilder)localObject).append("null");
      }
      label235:
      if ((TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextEditable)) && (aguk.b(this.jdField_c_of_type_AndroidTextEditable, "￼"))) {
        return 13;
      }
      if ((aguk.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (aguk.a(this.jdField_d_of_type_AndroidTextEditable, "\n")))
      {
        if ((this.jdField_d_of_type_AndroidTextEditable.length() >= 2) && (this.jdField_d_of_type_AndroidTextEditable.charAt(1) == "￼".charAt(0))) {
          return 14;
        }
        return 15;
      }
      if ((aguk.b(this.jdField_c_of_type_AndroidTextEditable, "\n")) && (aguk.a(this.jdField_d_of_type_AndroidTextEditable, "￼")))
      {
        if ((this.jdField_c_of_type_AndroidTextEditable.length() >= 2) && (this.jdField_c_of_type_AndroidTextEditable.charAt(this.jdField_c_of_type_AndroidTextEditable.length() - 2) == "￼".charAt(0))) {
          return 16;
        }
        return 17;
      }
      return -1;
    }
    if (this.jdField_b_of_type_Int > 0)
    {
      this.jdField_c_of_type_AndroidTextEditable = ((Editable)this.jdField_a_of_type_AndroidTextEditable.subSequence(0, this.jdField_a_of_type_Int));
      this.jdField_d_of_type_AndroidTextEditable = ((Editable)this.jdField_a_of_type_AndroidTextEditable.subSequence(this.jdField_a_of_type_Int + this.jdField_b_of_type_Int, this.jdField_a_of_type_AndroidTextEditable.length()));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("[mix]handle delete prefix: ");
        if (TextUtils.isEmpty(this.jdField_c_of_type_AndroidTextEditable)) {
          break label637;
        }
        ((StringBuilder)localObject).append(" prefix tail: ").append(this.jdField_c_of_type_AndroidTextEditable.charAt(this.jdField_c_of_type_AndroidTextEditable.length() - 1));
        ((StringBuilder)localObject).append(" suffix: ");
        if (TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextEditable)) {
          break label647;
        }
        ((StringBuilder)localObject).append(" suffix head: ").append(this.jdField_d_of_type_AndroidTextEditable.charAt(0));
      }
      for (;;)
      {
        QLog.d("FullScreenInputHelper", 2, new Object[] { localObject });
        localObject = this.jdField_a_of_type_AndroidTextEditable.subSequence(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.jdField_b_of_type_Int).toString();
        if ((((String)localObject).length() != 1) || (!((String)localObject).equals("\n"))) {
          break label737;
        }
        if ((!aguk.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) || (!aguk.a(this.jdField_d_of_type_AndroidTextEditable, "￼"))) {
          break label657;
        }
        return 6;
        label637:
        ((StringBuilder)localObject).append("null");
        break;
        label647:
        ((StringBuilder)localObject).append("null");
      }
      label657:
      if ((!aguk.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (!aguk.b(this.jdField_c_of_type_AndroidTextEditable, "\n")) && (aguk.a(this.jdField_d_of_type_AndroidTextEditable, "￼"))) {
        return 8;
      }
      if ((aguk.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (!aguk.a(this.jdField_d_of_type_AndroidTextEditable, "￼")) && (!aguk.a(this.jdField_d_of_type_AndroidTextEditable, "\n"))) {
        return 7;
      }
      return -1;
      label737:
      if ((aguk.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (aguk.a(this.jdField_d_of_type_AndroidTextEditable, "￼"))) {
        return 9;
      }
      if ((!aguk.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (!aguk.b(this.jdField_c_of_type_AndroidTextEditable, "\n")) && (aguk.a(this.jdField_d_of_type_AndroidTextEditable, "￼"))) {
        return 10;
      }
      if ((aguk.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (!aguk.a(this.jdField_d_of_type_AndroidTextEditable, "￼")) && (!aguk.a(this.jdField_d_of_type_AndroidTextEditable, "\n"))) {
        return 11;
      }
      return -1;
    }
    if (this.jdField_c_of_type_Int > 0)
    {
      this.jdField_c_of_type_AndroidTextEditable = ((Editable)this.jdField_a_of_type_AndroidTextEditable.subSequence(0, this.jdField_a_of_type_Int));
      this.jdField_d_of_type_AndroidTextEditable = ((Editable)this.jdField_a_of_type_AndroidTextEditable.subSequence(this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidTextEditable.length()));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder("[mix]handle add prefix: ");
        if (TextUtils.isEmpty(this.jdField_c_of_type_AndroidTextEditable)) {
          break label1032;
        }
        ((StringBuilder)localObject).append(" prefix tail: ").append(this.jdField_c_of_type_AndroidTextEditable.charAt(this.jdField_c_of_type_AndroidTextEditable.length() - 1));
        ((StringBuilder)localObject).append(" suffix: ");
        if (TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextEditable)) {
          break label1042;
        }
        ((StringBuilder)localObject).append(" suffix head: ").append(this.jdField_d_of_type_AndroidTextEditable.charAt(0));
      }
      for (;;)
      {
        QLog.d("FullScreenInputHelper", 2, new Object[] { localObject });
        if ((!TextUtils.isEmpty(this.jdField_c_of_type_AndroidTextEditable)) || (!aguk.a(this.jdField_d_of_type_AndroidTextEditable, "￼"))) {
          break label1052;
        }
        return 0;
        label1032:
        ((StringBuilder)localObject).append("null");
        break;
        label1042:
        ((StringBuilder)localObject).append("null");
      }
      label1052:
      if ((TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextEditable)) && (aguk.b(this.jdField_c_of_type_AndroidTextEditable, "￼"))) {
        return 1;
      }
      if ((aguk.b(this.jdField_c_of_type_AndroidTextEditable, "￼")) && (aguk.a(this.jdField_d_of_type_AndroidTextEditable, "\n")))
      {
        if ((this.jdField_d_of_type_AndroidTextEditable.length() >= 2) && (this.jdField_d_of_type_AndroidTextEditable.charAt(1) == "￼".charAt(0))) {
          return 2;
        }
        return 3;
      }
      if ((aguk.b(this.jdField_c_of_type_AndroidTextEditable, "\n")) && (aguk.a(this.jdField_d_of_type_AndroidTextEditable, "￼")))
      {
        if ((this.jdField_c_of_type_AndroidTextEditable.length() >= 2) && (this.jdField_c_of_type_AndroidTextEditable.charAt(this.jdField_c_of_type_AndroidTextEditable.length() - 2) == "￼".charAt(0))) {
          return 4;
        }
        return 5;
      }
      return -1;
    }
    return -1;
  }
  
  Editable a()
  {
    if (this.jdField_c_of_type_Int <= 0) {}
    while (this.jdField_b_of_type_AndroidTextEditable == null) {
      return null;
    }
    return (Editable)this.jdField_b_of_type_AndroidTextEditable.subSequence(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + this.jdField_c_of_type_Int);
  }
  
  void a(Editable paramEditable)
  {
    this.jdField_b_of_type_AndroidTextEditable = paramEditable;
  }
  
  void a(EditText paramEditText)
  {
    int k = 2;
    if (this.jdField_b_of_type_AndroidTextEditable.length() <= 0) {
      return;
    }
    Editable localEditable = a();
    paramEditText = paramEditText.getText();
    int i = Selection.getSelectionStart(paramEditText);
    int j = i;
    if (this.jdField_a_of_type_Int == this.jdField_a_of_type_AndroidTextEditable.length())
    {
      j = i;
      if (aguk.b(localEditable, "￼"))
      {
        localEditable.append("\n");
        j = i + 1;
      }
    }
    switch (this.jdField_d_of_type_Int)
    {
    default: 
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("FullScreenInputHelper", 2, "[mix] handle other at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
        i = j;
      }
      break;
    }
    while (this.jdField_d_of_type_Int != -1)
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      if (!TextUtils.isEmpty(this.jdField_c_of_type_AndroidTextEditable)) {
        localSpannableStringBuilder.append(this.jdField_c_of_type_AndroidTextEditable);
      }
      if (!TextUtils.isEmpty(localEditable)) {
        localSpannableStringBuilder.append(localEditable);
      }
      if (!TextUtils.isEmpty(this.jdField_d_of_type_AndroidTextEditable)) {
        localSpannableStringBuilder.append(this.jdField_d_of_type_AndroidTextEditable);
      }
      aguk.b(false);
      paramEditText.replace(0, paramEditText.length(), localSpannableStringBuilder);
      Selection.setSelection(paramEditText, Math.min(i, localSpannableStringBuilder.length()));
      aguk.b(true);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FullScreenInputHelper", 2, "[mix] handle add '_[img]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
      }
      localEditable.append("\n");
      i = j;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("FullScreenInputHelper", 2, "[mix] handle add '[img]_' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
      }
      localEditable.insert(0, "\n");
      i = j + 1;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("FullScreenInputHelper", 2, "[mix] handle add '[img]_\\n[img]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
      }
      i = j;
      if (!aguk.a(localEditable, "\n"))
      {
        localEditable.insert(0, "\n");
        i = j + 1;
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("FullScreenInputHelper", 2, "[mix] handle add '[img]_\\n[text]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
        }
        i = j;
        if (!aguk.a(localEditable, "\n"))
        {
          localEditable.insert(0, "\n");
          if (aguk.b(localEditable, "￼")) {}
          for (;;)
          {
            i = j + k;
            break;
            k = 1;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FullScreenInputHelper", 2, "[mix] handle add '[img]\\n_[img]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
          }
          i = j;
          if (!aguk.b(localEditable, "\n"))
          {
            localEditable.append("\n");
            i = j;
            continue;
            if (QLog.isColorLevel()) {
              QLog.d("FullScreenInputHelper", 2, "[mix] handle add '[text]\\n_[img]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
            }
            i = j;
            if (!aguk.b(localEditable, "\n"))
            {
              localEditable.append("\n");
              i = j;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("FullScreenInputHelper", 2, "[mix] handle del line '[img]_\\n_[img]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
              }
              this.jdField_c_of_type_AndroidTextEditable.delete(this.jdField_c_of_type_AndroidTextEditable.length() - 1, this.jdField_c_of_type_AndroidTextEditable.length());
              i = j - 1;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("FullScreenInputHelper", 2, "[mix] handle del line '[text]_\\n_[img]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
              }
              this.jdField_c_of_type_AndroidTextEditable.delete(this.jdField_c_of_type_AndroidTextEditable.length() - 1, this.jdField_c_of_type_AndroidTextEditable.length());
              this.jdField_c_of_type_AndroidTextEditable.append("\n");
              i = j - 1;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("FullScreenInputHelper", 2, "[mix] handle del line '[img]_\\n_[text]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
              }
              this.jdField_c_of_type_AndroidTextEditable.delete(this.jdField_c_of_type_AndroidTextEditable.length() - 1, this.jdField_c_of_type_AndroidTextEditable.length());
              i = j - 1;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("FullScreenInputHelper", 2, "[mix] handle del '[img]_[img]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
              }
              this.jdField_c_of_type_AndroidTextEditable.append("\n");
              i = j - 1;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("FullScreenInputHelper", 2, "[mix] handle del '[text]_[img]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
              }
              this.jdField_c_of_type_AndroidTextEditable.append("\n");
              i = j;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("FullScreenInputHelper", 2, "[mix] handle del '[img]_[text]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
              }
              this.jdField_c_of_type_AndroidTextEditable.append("\n");
              i = j + 1;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("FullScreenInputHelper", 2, "[mix] handle replace '_[img]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
              }
              localEditable.append("\n");
              i = j + 1;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("FullScreenInputHelper", 2, "[mix] handle replace '[img]_' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
              }
              localEditable.insert(0, "\n");
              i = j + 1;
              continue;
              if (QLog.isColorLevel()) {
                QLog.d("FullScreenInputHelper", 2, "[mix] handle replace '[img]_\\n[img]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
              }
              i = j;
              if (!aguk.a(localEditable, "\n"))
              {
                localEditable.insert(0, "\n");
                i = j + 1;
                continue;
                if (QLog.isColorLevel()) {
                  QLog.d("FullScreenInputHelper", 2, "[mix] handle replace '[img]_\\n[text]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
                }
                i = j;
                if (!aguk.a(localEditable, "\n"))
                {
                  localEditable.insert(0, "\n");
                  if (aguk.b(localEditable, "￼")) {}
                  for (;;)
                  {
                    i = j + k;
                    break;
                    k = 1;
                  }
                  if (QLog.isColorLevel()) {
                    QLog.d("FullScreenInputHelper", 2, "[mix] handle replace '[img]\\n_[img]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
                  }
                  i = j;
                  if (!aguk.b(localEditable, "\n"))
                  {
                    localEditable.append("\n");
                    i = j - 1;
                    continue;
                    if (QLog.isColorLevel()) {
                      QLog.d("FullScreenInputHelper", 2, "[mix] handle replace '[text]\\n_[img]' at position: " + this.jdField_a_of_type_Int + " prefix: " + this.jdField_c_of_type_AndroidTextEditable + " suffix: " + this.jdField_d_of_type_AndroidTextEditable);
                    }
                    i = j;
                    if (!aguk.b(localEditable, "\n"))
                    {
                      localEditable.append("\n");
                      i = j - 1;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  @NotNull
  public String toString()
  {
    return "<TextChangeInfo> {textBefore: " + this.jdField_a_of_type_AndroidTextEditable + " textAfter: " + this.jdField_b_of_type_AndroidTextEditable + " indexChange: " + this.jdField_a_of_type_Int + " countAdded: " + this.jdField_c_of_type_Int + " countDeleted: " + this.jdField_b_of_type_Int + "}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     agut
 * JD-Core Version:    0.7.0.1
 */