package com.tencent.ttpic.json;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.io.Writer;

public class JSONWriter
{
  private static final int maxdepth = 200;
  private boolean comma;
  protected char mode;
  private final JSONObject[] stack;
  private int top;
  protected Writer writer;
  
  public JSONWriter(Writer paramWriter)
  {
    AppMethodBeat.i(50199);
    this.comma = false;
    this.mode = 'i';
    this.stack = new JSONObject['È'];
    this.top = 0;
    this.writer = paramWriter;
    AppMethodBeat.o(50199);
  }
  
  private JSONWriter append(String paramString)
  {
    AppMethodBeat.i(50200);
    if (paramString == null)
    {
      paramString = new JSONException("Null pointer");
      AppMethodBeat.o(50200);
      throw paramString;
    }
    if ((this.mode == 'o') || (this.mode == 'a')) {
      try
      {
        if ((this.comma) && (this.mode == 'a')) {
          this.writer.write(44);
        }
        this.writer.write(paramString);
        if (this.mode == 'o') {
          this.mode = 'k';
        }
        this.comma = true;
        AppMethodBeat.o(50200);
        return this;
      }
      catch (IOException paramString)
      {
        paramString = new JSONException(paramString);
        AppMethodBeat.o(50200);
        throw paramString;
      }
    }
    paramString = new JSONException("Value out of sequence.");
    AppMethodBeat.o(50200);
    throw paramString;
  }
  
  private JSONWriter end(char paramChar1, char paramChar2)
  {
    AppMethodBeat.i(50202);
    if (this.mode != paramChar1)
    {
      if (paramChar1 == 'a') {}
      for (Object localObject = "Misplaced endArray.";; localObject = "Misplaced endObject.")
      {
        localObject = new JSONException((String)localObject);
        AppMethodBeat.o(50202);
        throw ((Throwable)localObject);
      }
    }
    pop(paramChar1);
    try
    {
      this.writer.write(paramChar2);
      this.comma = true;
      AppMethodBeat.o(50202);
      return this;
    }
    catch (IOException localIOException)
    {
      JSONException localJSONException = new JSONException(localIOException);
      AppMethodBeat.o(50202);
      throw localJSONException;
    }
  }
  
  private void pop(char paramChar)
  {
    char c1 = 'a';
    AppMethodBeat.i(50207);
    JSONException localJSONException;
    if (this.top <= 0)
    {
      localJSONException = new JSONException("Nesting error.");
      AppMethodBeat.o(50207);
      throw localJSONException;
    }
    if (this.stack[(this.top - 1)] == null) {}
    for (char c2 = 'a'; c2 != paramChar; c2 = 'k')
    {
      localJSONException = new JSONException("Nesting error.");
      AppMethodBeat.o(50207);
      throw localJSONException;
    }
    this.top -= 1;
    if (this.top == 0) {
      c1 = 'd';
    }
    for (;;)
    {
      this.mode = c1;
      AppMethodBeat.o(50207);
      return;
      if (this.stack[(this.top - 1)] != null) {
        c1 = 'k';
      }
    }
  }
  
  private void push(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(50208);
    if (this.top >= 200)
    {
      paramJSONObject = new JSONException("Nesting too deep.");
      AppMethodBeat.o(50208);
      throw paramJSONObject;
    }
    this.stack[this.top] = paramJSONObject;
    if (paramJSONObject == null) {}
    for (char c = 'a';; c = 'k')
    {
      this.mode = c;
      this.top += 1;
      AppMethodBeat.o(50208);
      return;
    }
  }
  
  public JSONWriter array()
  {
    AppMethodBeat.i(50201);
    if ((this.mode == 'i') || (this.mode == 'o') || (this.mode == 'a'))
    {
      push(null);
      append("[");
      this.comma = false;
      AppMethodBeat.o(50201);
      return this;
    }
    JSONException localJSONException = new JSONException("Misplaced array.");
    AppMethodBeat.o(50201);
    throw localJSONException;
  }
  
  public JSONWriter endArray()
  {
    AppMethodBeat.i(50203);
    JSONWriter localJSONWriter = end('a', ']');
    AppMethodBeat.o(50203);
    return localJSONWriter;
  }
  
  public JSONWriter endObject()
  {
    AppMethodBeat.i(50204);
    JSONWriter localJSONWriter = end('k', '}');
    AppMethodBeat.o(50204);
    return localJSONWriter;
  }
  
  public JSONWriter key(String paramString)
  {
    AppMethodBeat.i(50205);
    if (paramString == null)
    {
      paramString = new JSONException("Null key.");
      AppMethodBeat.o(50205);
      throw paramString;
    }
    if (this.mode == 'k') {
      try
      {
        this.stack[(this.top - 1)].putOnce(paramString, Boolean.TRUE);
        if (this.comma) {
          this.writer.write(44);
        }
        this.writer.write(JSONObject.quote(paramString));
        this.writer.write(58);
        this.comma = false;
        this.mode = 'o';
        AppMethodBeat.o(50205);
        return this;
      }
      catch (IOException paramString)
      {
        paramString = new JSONException(paramString);
        AppMethodBeat.o(50205);
        throw paramString;
      }
    }
    paramString = new JSONException("Misplaced key.");
    AppMethodBeat.o(50205);
    throw paramString;
  }
  
  public JSONWriter object()
  {
    AppMethodBeat.i(50206);
    if (this.mode == 'i') {
      this.mode = 'o';
    }
    if ((this.mode == 'o') || (this.mode == 'a'))
    {
      append("{");
      push(new JSONObject());
      this.comma = false;
      AppMethodBeat.o(50206);
      return this;
    }
    JSONException localJSONException = new JSONException("Misplaced object.");
    AppMethodBeat.o(50206);
    throw localJSONException;
  }
  
  public JSONWriter value(double paramDouble)
  {
    AppMethodBeat.i(50210);
    JSONWriter localJSONWriter = value(Double.valueOf(paramDouble));
    AppMethodBeat.o(50210);
    return localJSONWriter;
  }
  
  public JSONWriter value(long paramLong)
  {
    AppMethodBeat.i(50211);
    JSONWriter localJSONWriter = append(Long.toString(paramLong));
    AppMethodBeat.o(50211);
    return localJSONWriter;
  }
  
  public JSONWriter value(Object paramObject)
  {
    AppMethodBeat.i(50212);
    paramObject = append(JSONObject.valueToString(paramObject));
    AppMethodBeat.o(50212);
    return paramObject;
  }
  
  public JSONWriter value(boolean paramBoolean)
  {
    AppMethodBeat.i(50209);
    if (paramBoolean) {}
    for (Object localObject = "true";; localObject = "false")
    {
      localObject = append((String)localObject);
      AppMethodBeat.o(50209);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.json.JSONWriter
 * JD-Core Version:    0.7.0.1
 */