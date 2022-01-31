package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class ff
  implements Closeable
{
  private static final char[] a;
  private static final fj m;
  private final Reader b;
  private boolean c;
  private final char[] d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private long j;
  private int k;
  private String l;
  private int[] n;
  private int o;
  
  static
  {
    AppMethodBeat.i(147909);
    a = ")]}'\n".toCharArray();
    m = new fj();
    el.a = new ff.1();
    AppMethodBeat.o(147909);
  }
  
  public ff(Reader paramReader)
  {
    AppMethodBeat.i(147874);
    this.c = false;
    this.d = new char[1024];
    this.e = 0;
    this.f = 0;
    this.g = 0;
    this.h = 0;
    this.i = 0;
    this.n = new int[32];
    this.o = 0;
    int[] arrayOfInt = this.n;
    int i1 = this.o;
    this.o = (i1 + 1);
    arrayOfInt[i1] = 6;
    if (paramReader == null)
    {
      paramReader = new NullPointerException("in == null");
      AppMethodBeat.o(147874);
      throw paramReader;
    }
    this.b = paramReader;
    AppMethodBeat.o(147874);
  }
  
  private void a(int paramInt)
  {
    AppMethodBeat.i(98875);
    if (this.o == this.n.length)
    {
      arrayOfInt = new int[this.o * 2];
      System.arraycopy(this.n, 0, arrayOfInt, 0, this.o);
      this.n = arrayOfInt;
    }
    int[] arrayOfInt = this.n;
    int i1 = this.o;
    this.o = (i1 + 1);
    arrayOfInt[i1] = paramInt;
    AppMethodBeat.o(98875);
  }
  
  private boolean a(char paramChar)
  {
    AppMethodBeat.i(147884);
    switch (paramChar)
    {
    default: 
      AppMethodBeat.o(147884);
      return true;
    case '#': 
    case '/': 
    case ';': 
    case '=': 
    case '\\': 
      w();
    }
    AppMethodBeat.o(147884);
    return false;
  }
  
  private boolean a(String paramString)
  {
    AppMethodBeat.i(147902);
    while ((this.e + paramString.length() <= this.f) || (b(paramString.length()))) {
      if (this.d[this.e] == '\n')
      {
        this.g += 1;
        this.h = (this.e + 1);
        this.e += 1;
      }
      else
      {
        int i1 = 0;
        for (;;)
        {
          if (i1 >= paramString.length()) {
            break label115;
          }
          if (this.d[(this.e + i1)] != paramString.charAt(i1)) {
            break;
          }
          i1 += 1;
        }
        label115:
        AppMethodBeat.o(147902);
        return true;
      }
    }
    AppMethodBeat.o(147902);
    return false;
  }
  
  private int b(boolean paramBoolean)
  {
    AppMethodBeat.i(147899);
    Object localObject = this.d;
    int i1 = this.e;
    int i2 = this.f;
    for (;;)
    {
      int i3 = i2;
      int i4 = i1;
      if (i1 == i2)
      {
        this.e = i1;
        if (b(1))
        {
          i4 = this.e;
          i3 = this.f;
        }
      }
      else
      {
        i1 = i4 + 1;
        i2 = localObject[i4];
        if (i2 == 10)
        {
          this.g += 1;
          this.h = i1;
          i2 = i3;
          continue;
        }
        if ((i2 == 32) || (i2 == 13) || (i2 == 9)) {
          break label395;
        }
        if (i2 == 47)
        {
          this.e = i1;
          if (i1 == i3)
          {
            this.e -= 1;
            boolean bool = b(2);
            this.e += 1;
            if (!bool)
            {
              AppMethodBeat.o(147899);
              return i2;
            }
          }
          w();
          switch (localObject[this.e])
          {
          default: 
            AppMethodBeat.o(147899);
            return i2;
          case '*': 
            this.e += 1;
            if (!a("*/"))
            {
              localObject = b("Unterminated comment");
              AppMethodBeat.o(147899);
              throw ((Throwable)localObject);
            }
            i1 = this.e + 2;
            i2 = this.f;
            break;
          case '/': 
            this.e += 1;
            x();
            i1 = this.e;
            i2 = this.f;
            break;
          }
        }
        if (i2 == 35)
        {
          this.e = i1;
          w();
          x();
          i1 = this.e;
          i2 = this.f;
          continue;
        }
        this.e = i1;
        AppMethodBeat.o(147899);
        return i2;
      }
      if (paramBoolean)
      {
        localObject = new EOFException("End of input at line " + u() + " column " + v());
        AppMethodBeat.o(147899);
        throw ((Throwable)localObject);
      }
      AppMethodBeat.o(147899);
      return -1;
      label395:
      i2 = i3;
    }
  }
  
  private IOException b(String paramString)
  {
    AppMethodBeat.i(147904);
    paramString = new fi(paramString + " at line " + u() + " column " + v());
    AppMethodBeat.o(147904);
    throw paramString;
  }
  
  private String b(char paramChar)
  {
    AppMethodBeat.i(147891);
    char[] arrayOfChar = this.d;
    Object localObject1 = null;
    int i1 = 0;
    label235:
    do
    {
      char c3 = this.e;
      int i2 = this.f;
      char c1 = c3;
      for (;;)
      {
        if (c1 >= i2) {
          break label235;
        }
        char c2 = c1 + '\001';
        c1 = arrayOfChar[c1];
        if (c1 == paramChar)
        {
          this.e = c2;
          if (localObject1 == null)
          {
            localObject1 = m.a(arrayOfChar, c3, c2 - c3 - 1, i1);
            AppMethodBeat.o(147891);
            return localObject1;
          }
          ((StringBuilder)localObject1).append(arrayOfChar, c3, c2 - c3 - 1);
          localObject1 = ((StringBuilder)localObject1).toString();
          AppMethodBeat.o(147891);
          return localObject1;
        }
        if (c1 == '\\')
        {
          this.e = c2;
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder();
          }
          ((StringBuilder)localObject2).append(arrayOfChar, c3, c2 - c3 - 1);
          ((StringBuilder)localObject2).append(y());
          localObject1 = localObject2;
          break;
        }
        if (c1 == '\n')
        {
          i1 = i1 * 31 + c1;
          this.g += 1;
          this.h = c2;
          c1 = c2;
        }
        else
        {
          i1 = i1 * 31 + c1;
          c1 = c2;
        }
      }
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new StringBuilder();
      }
      ((StringBuilder)localObject2).append(arrayOfChar, c3, c1 - c3);
      this.e = c1;
      localObject1 = localObject2;
    } while (b(1));
    localObject1 = b("Unterminated string");
    AppMethodBeat.o(147891);
    throw ((Throwable)localObject1);
  }
  
  private boolean b(int paramInt)
  {
    AppMethodBeat.i(147898);
    char[] arrayOfChar = this.d;
    this.h -= this.e;
    if (this.f != this.e)
    {
      this.f -= this.e;
      System.arraycopy(arrayOfChar, this.e, arrayOfChar, 0, this.f);
    }
    for (;;)
    {
      this.e = 0;
      int i1;
      do
      {
        i1 = this.b.read(arrayOfChar, this.f, arrayOfChar.length - this.f);
        if (i1 == -1) {
          break;
        }
        this.f = (i1 + this.f);
        i1 = paramInt;
        if (this.g == 0)
        {
          i1 = paramInt;
          if (this.h == 0)
          {
            i1 = paramInt;
            if (this.f > 0)
            {
              i1 = paramInt;
              if (arrayOfChar[0] == 65279)
              {
                this.e += 1;
                this.h += 1;
                i1 = paramInt + 1;
              }
            }
          }
        }
        paramInt = i1;
      } while (this.f < i1);
      AppMethodBeat.o(147898);
      return true;
      this.f = 0;
    }
    AppMethodBeat.o(147898);
    return false;
  }
  
  private void c(char paramChar)
  {
    AppMethodBeat.i(147893);
    Object localObject = this.d;
    label98:
    do
    {
      char c1 = this.e;
      char c3 = this.f;
      for (;;)
      {
        if (c1 >= c3) {
          break label98;
        }
        char c2 = c1 + '\001';
        c1 = localObject[c1];
        if (c1 == paramChar)
        {
          this.e = c2;
          AppMethodBeat.o(147893);
          return;
        }
        if (c1 == '\\')
        {
          this.e = c2;
          y();
          break;
        }
        if (c1 == '\n')
        {
          this.g += 1;
          this.h = c2;
        }
        c1 = c2;
      }
      this.e = c1;
    } while (b(1));
    localObject = b("Unterminated string");
    AppMethodBeat.o(147893);
    throw ((Throwable)localObject);
  }
  
  private int o()
  {
    AppMethodBeat.i(147881);
    int i1 = this.n[(this.o - 1)];
    if (i1 == 1) {
      this.n[(this.o - 1)] = 2;
    }
    label671:
    do
    {
      for (;;)
      {
        switch (b(true))
        {
        default: 
          this.e -= 1;
          if (this.o == 1) {
            w();
          }
          i1 = q();
          if (i1 == 0) {
            break label831;
          }
          AppMethodBeat.o(147881);
          return i1;
          if (i1 == 2)
          {
            switch (b(true))
            {
            case 44: 
            default: 
              localObject = b("Unterminated array");
              AppMethodBeat.o(147881);
              throw ((Throwable)localObject);
            case 93: 
              this.i = 4;
              AppMethodBeat.o(147881);
              return 4;
            }
            w();
          }
          else
          {
            if ((i1 == 3) || (i1 == 5))
            {
              this.n[(this.o - 1)] = 4;
              if (i1 == 5) {
                switch (b(true))
                {
                default: 
                  localObject = b("Unterminated object");
                  AppMethodBeat.o(147881);
                  throw ((Throwable)localObject);
                case 125: 
                  this.i = 2;
                  AppMethodBeat.o(147881);
                  return 2;
                case 59: 
                  w();
                }
              }
              int i2 = b(true);
              switch (i2)
              {
              default: 
                w();
                this.e -= 1;
                if (a((char)i2))
                {
                  this.i = 14;
                  AppMethodBeat.o(147881);
                  return 14;
                }
                break;
              case 34: 
                this.i = 13;
                AppMethodBeat.o(147881);
                return 13;
              case 39: 
                w();
                this.i = 12;
                AppMethodBeat.o(147881);
                return 12;
              case 125: 
                if (i1 != 5)
                {
                  this.i = 2;
                  AppMethodBeat.o(147881);
                  return 2;
                }
                localObject = b("Expected name");
                AppMethodBeat.o(147881);
                throw ((Throwable)localObject);
              }
              localObject = b("Expected name");
              AppMethodBeat.o(147881);
              throw ((Throwable)localObject);
            }
            if (i1 == 4)
            {
              this.n[(this.o - 1)] = 5;
              switch (b(true))
              {
              case 58: 
              case 59: 
              case 60: 
              default: 
                localObject = b("Expected ':'");
                AppMethodBeat.o(147881);
                throw ((Throwable)localObject);
              }
              w();
              if (((this.e < this.f) || (b(1))) && (this.d[this.e] == '>')) {
                this.e += 1;
              }
            }
            else if (i1 == 6)
            {
              if (this.c) {
                z();
              }
              this.n[(this.o - 1)] = 7;
            }
            else
            {
              if (i1 != 7) {
                break label671;
              }
              if (b(false) == -1)
              {
                this.i = 17;
                AppMethodBeat.o(147881);
                return 17;
              }
              w();
              this.e -= 1;
            }
          }
          break;
        }
      }
    } while (i1 != 8);
    Object localObject = new IllegalStateException("JsonReader is closed");
    AppMethodBeat.o(147881);
    throw ((Throwable)localObject);
    if (i1 == 1)
    {
      this.i = 4;
      AppMethodBeat.o(147881);
      return 4;
    }
    if ((i1 == 1) || (i1 == 2))
    {
      w();
      this.e -= 1;
      this.i = 7;
      AppMethodBeat.o(147881);
      return 7;
    }
    localObject = b("Unexpected value");
    AppMethodBeat.o(147881);
    throw ((Throwable)localObject);
    w();
    this.i = 8;
    AppMethodBeat.o(147881);
    return 8;
    if (this.o == 1) {
      w();
    }
    this.i = 9;
    AppMethodBeat.o(147881);
    return 9;
    this.i = 3;
    AppMethodBeat.o(147881);
    return 3;
    this.i = 1;
    AppMethodBeat.o(147881);
    return 1;
    label831:
    i1 = r();
    if (i1 != 0)
    {
      AppMethodBeat.o(147881);
      return i1;
    }
    if (!a(this.d[this.e]))
    {
      localObject = b("Expected value");
      AppMethodBeat.o(147881);
      throw ((Throwable)localObject);
    }
    w();
    this.i = 10;
    AppMethodBeat.o(147881);
    return 10;
  }
  
  private int q()
  {
    AppMethodBeat.i(147882);
    int i1 = this.d[this.e];
    String str2;
    String str1;
    int i3;
    int i2;
    if ((i1 == 116) || (i1 == 84))
    {
      str2 = "true";
      str1 = "TRUE";
      i1 = 5;
      i3 = str2.length();
      i2 = 1;
    }
    for (;;)
    {
      if (i2 >= i3) {
        break label188;
      }
      if ((this.e + i2 >= this.f) && (!b(i2 + 1)))
      {
        AppMethodBeat.o(147882);
        return 0;
        if ((i1 == 102) || (i1 == 70))
        {
          str2 = "false";
          str1 = "FALSE";
          i1 = 6;
          break;
        }
        if ((i1 == 110) || (i1 == 78))
        {
          str2 = "null";
          str1 = "NULL";
          i1 = 7;
          break;
        }
        AppMethodBeat.o(147882);
        return 0;
      }
      int i4 = this.d[(this.e + i2)];
      if ((i4 != str2.charAt(i2)) && (i4 != str1.charAt(i2)))
      {
        AppMethodBeat.o(147882);
        return 0;
      }
      i2 += 1;
    }
    label188:
    if (((this.e + i3 < this.f) || (b(i3 + 1))) && (a(this.d[(this.e + i3)])))
    {
      AppMethodBeat.o(147882);
      return 0;
    }
    this.e += i3;
    this.i = i1;
    AppMethodBeat.o(147882);
    return i1;
  }
  
  private int r()
  {
    AppMethodBeat.i(147883);
    char[] arrayOfChar = this.d;
    int i7 = this.e;
    int i8 = this.f;
    long l1 = 0L;
    int i3 = 0;
    int i4 = 1;
    int i1 = 0;
    int i2 = 0;
    int i6 = i8;
    int i5 = i7;
    char c1;
    if (i7 + i2 == i8)
    {
      if (i2 == arrayOfChar.length)
      {
        AppMethodBeat.o(147883);
        return 0;
      }
      if (b(i2 + 1))
      {
        i5 = this.e;
        i6 = this.f;
      }
    }
    else
    {
      c1 = arrayOfChar[(i5 + i2)];
      switch (c1)
      {
      default: 
        if ((c1 < '0') || (c1 > '9'))
        {
          if (!a(c1)) {
            break label405;
          }
          AppMethodBeat.o(147883);
          return 0;
        }
        break;
      case '-': 
        if (i1 == 0)
        {
          i1 = 1;
          i3 = 1;
        }
        break;
      }
    }
    for (;;)
    {
      i2 += 1;
      i8 = i6;
      i7 = i5;
      break;
      if (i1 == 5)
      {
        i1 = 6;
      }
      else
      {
        AppMethodBeat.o(147883);
        return 0;
        if (i1 == 5)
        {
          i1 = 6;
        }
        else
        {
          AppMethodBeat.o(147883);
          return 0;
          if ((i1 == 2) || (i1 == 4))
          {
            i1 = 5;
          }
          else
          {
            AppMethodBeat.o(147883);
            return 0;
            if (i1 == 2)
            {
              i1 = 3;
            }
            else
            {
              AppMethodBeat.o(147883);
              return 0;
              if ((i1 == 1) || (i1 == 0))
              {
                l1 = -(c1 - '0');
                i1 = 2;
              }
              else
              {
                if (i1 == 2)
                {
                  if (l1 == 0L)
                  {
                    AppMethodBeat.o(147883);
                    return 0;
                  }
                  long l2 = 10L * l1 - (c1 - '0');
                  if ((l1 > -922337203685477580L) || ((l1 == -922337203685477580L) && (l2 < l1))) {}
                  for (i7 = 1;; i7 = 0)
                  {
                    i4 &= i7;
                    l1 = l2;
                    break;
                  }
                }
                if (i1 == 3)
                {
                  i1 = 4;
                }
                else if ((i1 == 5) || (i1 == 6))
                {
                  i1 = 7;
                  continue;
                  label405:
                  if ((i1 == 2) && (i4 != 0) && ((l1 != -9223372036854775808L) || (i3 != 0)))
                  {
                    if (i3 != 0) {}
                    for (;;)
                    {
                      this.j = l1;
                      this.e += i2;
                      this.i = 15;
                      AppMethodBeat.o(147883);
                      return 15;
                      l1 = -l1;
                    }
                  }
                  if ((i1 == 2) || (i1 == 4) || (i1 == 7))
                  {
                    this.k = i2;
                    this.i = 16;
                    AppMethodBeat.o(147883);
                    return 16;
                  }
                  AppMethodBeat.o(147883);
                  return 0;
                }
              }
            }
          }
        }
      }
    }
  }
  
  private String s()
  {
    AppMethodBeat.i(147892);
    Object localObject1 = null;
    int i1 = 0;
    for (;;)
    {
      Object localObject2;
      int i2;
      if (this.e + i1 < this.f)
      {
        localObject2 = localObject1;
        i2 = i1;
        switch (this.d[(this.e + i1)])
        {
        default: 
          i1 += 1;
          break;
        case '#': 
        case '/': 
        case ';': 
        case '=': 
        case '\\': 
          w();
          i2 = i1;
          localObject2 = localObject1;
        case '\t': 
        case '\n': 
        case '\f': 
        case '\r': 
        case ' ': 
        case ',': 
        case ':': 
        case '[': 
        case ']': 
        case '{': 
        case '}': 
          label192:
          if (localObject2 != null) {}
          break;
        }
      }
      else
      {
        for (localObject1 = new String(this.d, this.e, i2);; localObject1 = ((StringBuilder)localObject2).toString())
        {
          this.e = (i2 + this.e);
          AppMethodBeat.o(147892);
          return localObject1;
          if (i1 < this.d.length)
          {
            localObject2 = localObject1;
            i2 = i1;
            if (!b(i1 + 1)) {
              break label192;
            }
            break;
          }
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = new StringBuilder();
          }
          ((StringBuilder)localObject2).append(this.d, this.e, i1);
          this.e = (i1 + this.e);
          if (b(1)) {
            break label337;
          }
          i2 = 0;
          break label192;
          ((StringBuilder)localObject2).append(this.d, this.e, i2);
        }
        label337:
        i1 = 0;
        localObject1 = localObject2;
      }
    }
  }
  
  private void t()
  {
    AppMethodBeat.i(147894);
    do
    {
      int i1 = 0;
      while (this.e + i1 < this.f) {
        switch (this.d[(this.e + i1)])
        {
        default: 
          i1 += 1;
          break;
        case '#': 
        case '/': 
        case ';': 
        case '=': 
        case '\\': 
          w();
        case '\t': 
        case '\n': 
        case '\f': 
        case '\r': 
        case ' ': 
        case ',': 
        case ':': 
        case '[': 
        case ']': 
        case '{': 
        case '}': 
          this.e = (i1 + this.e);
          AppMethodBeat.o(147894);
          return;
        }
      }
      this.e = (i1 + this.e);
    } while (b(1));
    AppMethodBeat.o(147894);
  }
  
  private int u()
  {
    return this.g + 1;
  }
  
  private int v()
  {
    return this.e - this.h + 1;
  }
  
  private void w()
  {
    AppMethodBeat.i(147900);
    if (!this.c)
    {
      IOException localIOException = b("Use JsonReader.setLenient(true) to accept malformed JSON");
      AppMethodBeat.o(147900);
      throw localIOException;
    }
    AppMethodBeat.o(147900);
  }
  
  private void x()
  {
    AppMethodBeat.i(147901);
    int i1;
    do
    {
      if ((this.e >= this.f) && (!b(1))) {
        break;
      }
      char[] arrayOfChar = this.d;
      i1 = this.e;
      this.e = (i1 + 1);
      i1 = arrayOfChar[i1];
      if (i1 == 10)
      {
        this.g += 1;
        this.h = this.e;
        AppMethodBeat.o(147901);
        return;
      }
    } while (i1 != 13);
    AppMethodBeat.o(147901);
  }
  
  private char y()
  {
    AppMethodBeat.i(147903);
    if ((this.e == this.f) && (!b(1)))
    {
      localObject = b("Unterminated escape sequence");
      AppMethodBeat.o(147903);
      throw ((Throwable)localObject);
    }
    Object localObject = this.d;
    int i1 = this.e;
    this.e = (i1 + 1);
    char c1 = localObject[i1];
    switch (c1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(147903);
      return c1;
      if ((this.e + 4 > this.f) && (!b(4)))
      {
        localObject = b("Unterminated escape sequence");
        AppMethodBeat.o(147903);
        throw ((Throwable)localObject);
      }
      c1 = '\000';
      int i2 = this.e;
      i1 = i2;
      if (i1 < i2 + 4)
      {
        int i3 = this.d[i1];
        int i4 = (char)(c1 << '\004');
        if ((i3 >= 48) && (i3 <= 57)) {
          c1 = (char)(i4 + (i3 - 48));
        }
        for (;;)
        {
          i1 += 1;
          break;
          if ((i3 >= 97) && (i3 <= 102))
          {
            c1 = (char)(i4 + (i3 - 97 + 10));
          }
          else
          {
            if ((i3 < 65) || (i3 > 70)) {
              break label300;
            }
            c1 = (char)(i4 + (i3 - 65 + 10));
          }
        }
        label300:
        localObject = new NumberFormatException("\\u" + new String(this.d, this.e, 4));
        AppMethodBeat.o(147903);
        throw ((Throwable)localObject);
      }
      this.e += 4;
      AppMethodBeat.o(147903);
      return c1;
      AppMethodBeat.o(147903);
      return '\t';
      AppMethodBeat.o(147903);
      return '\b';
      AppMethodBeat.o(147903);
      return '\n';
      AppMethodBeat.o(147903);
      return '\r';
      AppMethodBeat.o(147903);
      return '\f';
      this.g += 1;
      this.h = this.e;
    }
  }
  
  private void z()
  {
    AppMethodBeat.i(147905);
    b(true);
    this.e -= 1;
    if ((this.e + a.length > this.f) && (!b(a.length)))
    {
      AppMethodBeat.o(147905);
      return;
    }
    int i1 = 0;
    while (i1 < a.length)
    {
      if (this.d[(this.e + i1)] != a[i1])
      {
        AppMethodBeat.o(147905);
        return;
      }
      i1 += 1;
    }
    this.e += a.length;
    AppMethodBeat.o(147905);
  }
  
  public void a()
  {
    AppMethodBeat.i(147875);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 3)
    {
      a(1);
      this.i = 0;
      AppMethodBeat.o(147875);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Expected BEGIN_ARRAY but was " + f() + " at line " + u() + " column " + v());
    AppMethodBeat.o(147875);
    throw localIllegalStateException;
  }
  
  public final void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void b()
  {
    AppMethodBeat.i(147876);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 4)
    {
      this.o -= 1;
      this.i = 0;
      AppMethodBeat.o(147876);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Expected END_ARRAY but was " + f() + " at line " + u() + " column " + v());
    AppMethodBeat.o(147876);
    throw localIllegalStateException;
  }
  
  public void c()
  {
    AppMethodBeat.i(147877);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 1)
    {
      a(3);
      this.i = 0;
      AppMethodBeat.o(147877);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Expected BEGIN_OBJECT but was " + f() + " at line " + u() + " column " + v());
    AppMethodBeat.o(147877);
    throw localIllegalStateException;
  }
  
  public void close()
  {
    AppMethodBeat.i(147896);
    this.i = 0;
    this.n[0] = 8;
    this.o = 1;
    this.b.close();
    AppMethodBeat.o(147896);
  }
  
  public void d()
  {
    AppMethodBeat.i(147878);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 2)
    {
      this.o -= 1;
      this.i = 0;
      AppMethodBeat.o(147878);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Expected END_OBJECT but was " + f() + " at line " + u() + " column " + v());
    AppMethodBeat.o(147878);
    throw localIllegalStateException;
  }
  
  public boolean e()
  {
    AppMethodBeat.i(147879);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if ((i1 != 2) && (i1 != 4))
    {
      AppMethodBeat.o(147879);
      return true;
    }
    AppMethodBeat.o(147879);
    return false;
  }
  
  public fg f()
  {
    AppMethodBeat.i(147880);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    switch (i1)
    {
    default: 
      localObject = new AssertionError();
      AppMethodBeat.o(147880);
      throw ((Throwable)localObject);
    case 1: 
      localObject = fg.c;
      AppMethodBeat.o(147880);
      return localObject;
    case 2: 
      localObject = fg.d;
      AppMethodBeat.o(147880);
      return localObject;
    case 3: 
      localObject = fg.a;
      AppMethodBeat.o(147880);
      return localObject;
    case 4: 
      localObject = fg.b;
      AppMethodBeat.o(147880);
      return localObject;
    case 12: 
    case 13: 
    case 14: 
      localObject = fg.e;
      AppMethodBeat.o(147880);
      return localObject;
    case 5: 
    case 6: 
      localObject = fg.h;
      AppMethodBeat.o(147880);
      return localObject;
    case 7: 
      localObject = fg.i;
      AppMethodBeat.o(147880);
      return localObject;
    case 8: 
    case 9: 
    case 10: 
    case 11: 
      localObject = fg.f;
      AppMethodBeat.o(147880);
      return localObject;
    case 15: 
    case 16: 
      localObject = fg.g;
      AppMethodBeat.o(147880);
      return localObject;
    }
    Object localObject = fg.j;
    AppMethodBeat.o(147880);
    return localObject;
  }
  
  public String g()
  {
    AppMethodBeat.i(147885);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 14) {
      localObject = s();
    }
    for (;;)
    {
      this.i = 0;
      AppMethodBeat.o(147885);
      return localObject;
      if (i1 == 12)
      {
        localObject = b('\'');
      }
      else
      {
        if (i1 != 13) {
          break;
        }
        localObject = b('"');
      }
    }
    Object localObject = new IllegalStateException("Expected a name but was " + f() + " at line " + u() + " column " + v());
    AppMethodBeat.o(147885);
    throw ((Throwable)localObject);
  }
  
  public String h()
  {
    AppMethodBeat.i(147886);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 10) {
      localObject = s();
    }
    for (;;)
    {
      this.i = 0;
      AppMethodBeat.o(147886);
      return localObject;
      if (i1 == 8)
      {
        localObject = b('\'');
      }
      else if (i1 == 9)
      {
        localObject = b('"');
      }
      else if (i1 == 11)
      {
        localObject = this.l;
        this.l = null;
      }
      else if (i1 == 15)
      {
        localObject = Long.toString(this.j);
      }
      else
      {
        if (i1 != 16) {
          break;
        }
        localObject = new String(this.d, this.e, this.k);
        this.e += this.k;
      }
    }
    Object localObject = new IllegalStateException("Expected a string but was " + f() + " at line " + u() + " column " + v());
    AppMethodBeat.o(147886);
    throw ((Throwable)localObject);
  }
  
  public boolean i()
  {
    AppMethodBeat.i(147887);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 5)
    {
      this.i = 0;
      AppMethodBeat.o(147887);
      return true;
    }
    if (i1 == 6)
    {
      this.i = 0;
      AppMethodBeat.o(147887);
      return false;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Expected a boolean but was " + f() + " at line " + u() + " column " + v());
    AppMethodBeat.o(147887);
    throw localIllegalStateException;
  }
  
  public void j()
  {
    AppMethodBeat.i(147888);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    if (i1 == 7)
    {
      this.i = 0;
      AppMethodBeat.o(147888);
      return;
    }
    IllegalStateException localIllegalStateException = new IllegalStateException("Expected null but was " + f() + " at line " + u() + " column " + v());
    AppMethodBeat.o(147888);
    throw localIllegalStateException;
  }
  
  public double k()
  {
    AppMethodBeat.i(147889);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    double d1;
    if (i1 == 15)
    {
      this.i = 0;
      d1 = this.j;
      AppMethodBeat.o(147889);
      return d1;
    }
    if (i1 == 16)
    {
      this.l = new String(this.d, this.e, this.k);
      this.e += this.k;
    }
    do
    {
      for (;;)
      {
        this.i = 11;
        d1 = Double.parseDouble(this.l);
        if ((this.c) || ((!Double.isNaN(d1)) && (!Double.isInfinite(d1)))) {
          break label319;
        }
        localObject = new fi("JSON forbids NaN and infinities: " + d1 + " at line " + u() + " column " + v());
        AppMethodBeat.o(147889);
        throw ((Throwable)localObject);
        if ((i1 == 8) || (i1 == 9))
        {
          if (i1 == 8) {}
          for (char c1 = '\'';; c1 = '"')
          {
            this.l = b(c1);
            break;
          }
        }
        if (i1 != 10) {
          break;
        }
        this.l = s();
      }
    } while (i1 == 11);
    Object localObject = new IllegalStateException("Expected a double but was " + f() + " at line " + u() + " column " + v());
    AppMethodBeat.o(147889);
    throw ((Throwable)localObject);
    label319:
    this.l = null;
    this.i = 0;
    AppMethodBeat.o(147889);
    return d1;
  }
  
  public long l()
  {
    AppMethodBeat.i(147890);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    long l1;
    if (i1 == 15)
    {
      this.i = 0;
      l1 = this.j;
      AppMethodBeat.o(147890);
      return l1;
    }
    if (i1 == 16)
    {
      this.l = new String(this.d, this.e, this.k);
      this.e += this.k;
    }
    for (;;)
    {
      this.i = 11;
      double d1 = Double.parseDouble(this.l);
      l1 = d1;
      if (l1 != d1)
      {
        Object localObject = new NumberFormatException("Expected a long but was " + this.l + " at line " + u() + " column " + v());
        AppMethodBeat.o(147890);
        throw ((Throwable)localObject);
        if ((i1 == 8) || (i1 == 9))
        {
          if (i1 == 8) {}
          for (char c1 = '\'';; c1 = '"')
          {
            this.l = b(c1);
            try
            {
              l1 = Long.parseLong(this.l);
              this.i = 0;
              AppMethodBeat.o(147890);
              return l1;
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        else
        {
          localObject = new IllegalStateException("Expected a long but was " + f() + " at line " + u() + " column " + v());
          AppMethodBeat.o(147890);
          throw ((Throwable)localObject);
        }
      }
      else
      {
        this.l = null;
        this.i = 0;
        AppMethodBeat.o(147890);
        return l1;
      }
    }
  }
  
  public int m()
  {
    AppMethodBeat.i(147895);
    int i2 = this.i;
    int i1 = i2;
    if (i2 == 0) {
      i1 = o();
    }
    Object localObject;
    if (i1 == 15)
    {
      i1 = (int)this.j;
      if (this.j != i1)
      {
        localObject = new NumberFormatException("Expected an int but was " + this.j + " at line " + u() + " column " + v());
        AppMethodBeat.o(147895);
        throw ((Throwable)localObject);
      }
      this.i = 0;
      AppMethodBeat.o(147895);
      return i1;
    }
    if (i1 == 16)
    {
      this.l = new String(this.d, this.e, this.k);
      this.e += this.k;
    }
    for (;;)
    {
      this.i = 11;
      double d1 = Double.parseDouble(this.l);
      i1 = (int)d1;
      if (i1 != d1)
      {
        localObject = new NumberFormatException("Expected an int but was " + this.l + " at line " + u() + " column " + v());
        AppMethodBeat.o(147895);
        throw ((Throwable)localObject);
        if ((i1 == 8) || (i1 == 9))
        {
          if (i1 == 8) {}
          for (char c1 = '\'';; c1 = '"')
          {
            this.l = b(c1);
            try
            {
              i1 = Integer.parseInt(this.l);
              this.i = 0;
              AppMethodBeat.o(147895);
              return i1;
            }
            catch (NumberFormatException localNumberFormatException) {}
          }
        }
        else
        {
          localObject = new IllegalStateException("Expected an int but was " + f() + " at line " + u() + " column " + v());
          AppMethodBeat.o(147895);
          throw ((Throwable)localObject);
        }
      }
      else
      {
        this.l = null;
        this.i = 0;
        AppMethodBeat.o(147895);
        return i1;
      }
    }
  }
  
  public void n()
  {
    AppMethodBeat.i(147897);
    int i2 = 0;
    int i1 = this.i;
    int i3 = i1;
    if (i1 == 0) {
      i3 = o();
    }
    if (i3 == 3)
    {
      a(1);
      i1 = i2 + 1;
    }
    for (;;)
    {
      this.i = 0;
      i2 = i1;
      if (i1 != 0) {
        break;
      }
      AppMethodBeat.o(147897);
      return;
      if (i3 == 1)
      {
        a(3);
        i1 = i2 + 1;
      }
      else if (i3 == 4)
      {
        this.o -= 1;
        i1 = i2 - 1;
      }
      else if (i3 == 2)
      {
        this.o -= 1;
        i1 = i2 - 1;
      }
      else if ((i3 == 14) || (i3 == 10))
      {
        t();
        i1 = i2;
      }
      else if ((i3 == 8) || (i3 == 12))
      {
        c('\'');
        i1 = i2;
      }
      else if ((i3 == 9) || (i3 == 13))
      {
        c('"');
        i1 = i2;
      }
      else
      {
        i1 = i2;
        if (i3 == 16)
        {
          this.e += this.k;
          i1 = i2;
        }
      }
    }
  }
  
  public final boolean p()
  {
    return this.c;
  }
  
  public String toString()
  {
    AppMethodBeat.i(98882);
    String str = getClass().getSimpleName() + " at line " + u() + " column " + v();
    AppMethodBeat.o(98882);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.a.ff
 * JD-Core Version:    0.7.0.1
 */