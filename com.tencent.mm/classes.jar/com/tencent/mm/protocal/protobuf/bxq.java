package com.tencent.mm.protocal.protobuf;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class bxq
  extends com.tencent.mm.bx.a
{
  public String Nnp;
  public dbh aagA;
  public hq aagB;
  public int aagq;
  public int aagr;
  public b aags;
  public LinkedList<String> aagt;
  public adf aagu;
  public int aagv;
  public int aagw;
  public int aagx;
  public int aagy;
  public int aagz;
  public int akkS;
  public int count;
  public String icon_url;
  public String path;
  public int show_type;
  public String title;
  
  public bxq()
  {
    AppMethodBeat.i(258323);
    this.aagt = new LinkedList();
    AppMethodBeat.o(258323);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258327);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "show_type", Integer.valueOf(this.show_type), true);
      com.tencent.mm.bk.a.a(localJSONObject, "count", Integer.valueOf(this.count), true);
      com.tencent.mm.bk.a.a(localJSONObject, "title", this.title, true);
      com.tencent.mm.bk.a.a(localJSONObject, "icon_url", this.icon_url, true);
      com.tencent.mm.bk.a.a(localJSONObject, "clear_type", Integer.valueOf(this.aagq), true);
      com.tencent.mm.bk.a.a(localJSONObject, "path", this.path, true);
      com.tencent.mm.bk.a.a(localJSONObject, "parent", this.Nnp, true);
      com.tencent.mm.bk.a.a(localJSONObject, "show_ext_info_type", Integer.valueOf(this.aagr), true);
      com.tencent.mm.bk.a.a(localJSONObject, "show_ext_info", this.aags, true);
      com.tencent.mm.bk.a.a(localJSONObject, "multi_icon_urls", this.aagt, true);
      com.tencent.mm.bk.a.a(localJSONObject, "client_stats_info", this.aagu, true);
      com.tencent.mm.bk.a.a(localJSONObject, "show_live_tab_id", Integer.valueOf(this.aagv), true);
      com.tencent.mm.bk.a.a(localJSONObject, "ignore_freq_limit", Integer.valueOf(this.aagw), true);
      com.tencent.mm.bk.a.a(localJSONObject, "expose_count_limit", Integer.valueOf(this.aagx), true);
      com.tencent.mm.bk.a.a(localJSONObject, "expose_limit_strategy", Integer.valueOf(this.aagy), true);
      com.tencent.mm.bk.a.a(localJSONObject, "cold_time", Integer.valueOf(this.aagz), true);
      com.tencent.mm.bk.a.a(localJSONObject, "iconConfig", this.aagA, true);
      com.tencent.mm.bk.a.a(localJSONObject, "attributeTitle", this.aagB, true);
      com.tencent.mm.bk.a.a(localJSONObject, "cacheChangeTabOption", Integer.valueOf(this.akkS), true);
      label252:
      AppMethodBeat.o(258327);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label252;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184212);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.show_type);
      paramVarArgs.bS(2, this.count);
      if (this.title != null) {
        paramVarArgs.g(3, this.title);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(4, this.icon_url);
      }
      paramVarArgs.bS(5, this.aagq);
      if (this.path != null) {
        paramVarArgs.g(6, this.path);
      }
      if (this.Nnp != null) {
        paramVarArgs.g(7, this.Nnp);
      }
      paramVarArgs.bS(8, this.aagr);
      if (this.aags != null) {
        paramVarArgs.d(9, this.aags);
      }
      paramVarArgs.e(10, 1, this.aagt);
      if (this.aagu != null)
      {
        paramVarArgs.qD(11, this.aagu.computeSize());
        this.aagu.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.aagv);
      paramVarArgs.bS(13, this.aagw);
      paramVarArgs.bS(14, this.aagx);
      paramVarArgs.bS(15, this.aagy);
      paramVarArgs.bS(16, this.aagz);
      if (this.aagA != null)
      {
        paramVarArgs.qD(17, this.aagA.computeSize());
        this.aagA.writeFields(paramVarArgs);
      }
      if (this.aagB != null)
      {
        paramVarArgs.qD(18, this.aagB.computeSize());
        this.aagB.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(19, this.akkS);
      AppMethodBeat.o(184212);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.show_type) + 0 + i.a.a.b.b.a.cJ(2, this.count);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.title);
      }
      i = paramInt;
      if (this.icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.icon_url);
      }
      i += i.a.a.b.b.a.cJ(5, this.aagq);
      paramInt = i;
      if (this.path != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.path);
      }
      i = paramInt;
      if (this.Nnp != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Nnp);
      }
      i += i.a.a.b.b.a.cJ(8, this.aagr);
      paramInt = i;
      if (this.aags != null) {
        paramInt = i + i.a.a.b.b.a.c(9, this.aags);
      }
      i = paramInt + i.a.a.a.c(10, 1, this.aagt);
      paramInt = i;
      if (this.aagu != null) {
        paramInt = i + i.a.a.a.qC(11, this.aagu.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.aagv) + i.a.a.b.b.a.cJ(13, this.aagw) + i.a.a.b.b.a.cJ(14, this.aagx) + i.a.a.b.b.a.cJ(15, this.aagy) + i.a.a.b.b.a.cJ(16, this.aagz);
      paramInt = i;
      if (this.aagA != null) {
        paramInt = i + i.a.a.a.qC(17, this.aagA.computeSize());
      }
      i = paramInt;
      if (this.aagB != null) {
        i = paramInt + i.a.a.a.qC(18, this.aagB.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(19, this.akkS);
      AppMethodBeat.o(184212);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aagt.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(184212);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bxq localbxq = (bxq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184212);
        return -1;
      case 1: 
        localbxq.show_type = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184212);
        return 0;
      case 2: 
        localbxq.count = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184212);
        return 0;
      case 3: 
        localbxq.title = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 4: 
        localbxq.icon_url = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 5: 
        localbxq.aagq = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184212);
        return 0;
      case 6: 
        localbxq.path = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 7: 
        localbxq.Nnp = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(184212);
        return 0;
      case 8: 
        localbxq.aagr = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184212);
        return 0;
      case 9: 
        localbxq.aags = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(184212);
        return 0;
      case 10: 
        localbxq.aagt.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(184212);
        return 0;
      case 11: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new adf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((adf)localObject2).parseFrom((byte[])localObject1);
          }
          localbxq.aagu = ((adf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184212);
        return 0;
      case 12: 
        localbxq.aagv = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184212);
        return 0;
      case 13: 
        localbxq.aagw = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184212);
        return 0;
      case 14: 
        localbxq.aagx = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184212);
        return 0;
      case 15: 
        localbxq.aagy = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184212);
        return 0;
      case 16: 
        localbxq.aagz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(184212);
        return 0;
      case 17: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dbh();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dbh)localObject2).parseFrom((byte[])localObject1);
          }
          localbxq.aagA = ((dbh)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184212);
        return 0;
      case 18: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new hq();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((hq)localObject2).parseFrom((byte[])localObject1);
          }
          localbxq.aagB = ((hq)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(184212);
        return 0;
      }
      localbxq.akkS = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(184212);
      return 0;
    }
    AppMethodBeat.o(184212);
    return -1;
  }
  
  public final com.tencent.mm.bx.a toPb(String paramString)
  {
    AppMethodBeat.i(258337);
    if ((paramString == null) || ("" == paramString))
    {
      AppMethodBeat.o(258337);
      return this;
    }
    for (;;)
    {
      Object localObject;
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        if (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          i = -1;
        }
        switch (((String)localObject).hashCode())
        {
        case -1903312068: 
          this.show_type = ((Integer)paramString.opt((String)localObject)).intValue();
          continue;
          if (!((String)localObject).equals("show_type")) {
            break label1028;
          }
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("FinderTipsShowInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(258337);
        return this;
      }
      int i = 0;
      break label1028;
      if (((String)localObject).equals("count"))
      {
        i = 1;
        break label1028;
        if (((String)localObject).equals("title"))
        {
          i = 2;
          break label1028;
          if (((String)localObject).equals("icon_url"))
          {
            i = 3;
            break label1028;
            if (((String)localObject).equals("clear_type"))
            {
              i = 4;
              break label1028;
              if (((String)localObject).equals("path"))
              {
                i = 5;
                break label1028;
                if (((String)localObject).equals("parent"))
                {
                  i = 6;
                  break label1028;
                  if (((String)localObject).equals("show_ext_info_type"))
                  {
                    i = 7;
                    break label1028;
                    if (((String)localObject).equals("show_ext_info"))
                    {
                      i = 8;
                      break label1028;
                      if (((String)localObject).equals("multi_icon_urls"))
                      {
                        i = 9;
                        break label1028;
                        if (((String)localObject).equals("client_stats_info"))
                        {
                          i = 10;
                          break label1028;
                          if (((String)localObject).equals("show_live_tab_id"))
                          {
                            i = 11;
                            break label1028;
                            if (((String)localObject).equals("ignore_freq_limit"))
                            {
                              i = 12;
                              break label1028;
                              if (((String)localObject).equals("expose_count_limit"))
                              {
                                i = 13;
                                break label1028;
                                if (((String)localObject).equals("expose_limit_strategy"))
                                {
                                  i = 14;
                                  break label1028;
                                  if (((String)localObject).equals("cold_time"))
                                  {
                                    i = 15;
                                    break label1028;
                                    if (((String)localObject).equals("iconConfig"))
                                    {
                                      i = 16;
                                      break label1028;
                                      if (((String)localObject).equals("attributeTitle"))
                                      {
                                        i = 17;
                                        break label1028;
                                        if (((String)localObject).equals("cacheChangeTabOption"))
                                        {
                                          i = 18;
                                          break label1028;
                                          this.count = ((Integer)paramString.opt((String)localObject)).intValue();
                                          continue;
                                          this.title = ((String)paramString.opt((String)localObject));
                                          continue;
                                          this.icon_url = ((String)paramString.opt((String)localObject));
                                          continue;
                                          this.aagq = ((Integer)paramString.opt((String)localObject)).intValue();
                                          continue;
                                          this.path = ((String)paramString.opt((String)localObject));
                                          continue;
                                          this.Nnp = ((String)paramString.opt((String)localObject));
                                          continue;
                                          this.aagr = ((Integer)paramString.opt((String)localObject)).intValue();
                                          continue;
                                          localObject = paramString.opt((String)localObject);
                                          if (!(localObject instanceof String)) {
                                            continue;
                                          }
                                          this.aags = b.cX(Base64.decode((String)localObject, 0));
                                          continue;
                                          localObject = paramString.opt((String)localObject);
                                          if (!(localObject instanceof JSONArray)) {
                                            continue;
                                          }
                                          localObject = (JSONArray)localObject;
                                          i = 0;
                                          while (i < ((JSONArray)localObject).length())
                                          {
                                            this.aagt.add((String)((JSONArray)localObject).get(i));
                                            i += 1;
                                          }
                                          continue;
                                          localObject = paramString.opt((String)localObject);
                                          if (!(localObject instanceof JSONObject)) {
                                            continue;
                                          }
                                          this.aagu = ((adf)new adf().toPb(((JSONObject)localObject).toString()));
                                          continue;
                                          this.aagv = ((Integer)paramString.opt((String)localObject)).intValue();
                                          continue;
                                          this.aagw = ((Integer)paramString.opt((String)localObject)).intValue();
                                          continue;
                                          this.aagx = ((Integer)paramString.opt((String)localObject)).intValue();
                                          continue;
                                          this.aagy = ((Integer)paramString.opt((String)localObject)).intValue();
                                          continue;
                                          this.aagz = ((Integer)paramString.opt((String)localObject)).intValue();
                                          continue;
                                          localObject = paramString.opt((String)localObject);
                                          if (!(localObject instanceof JSONObject)) {
                                            continue;
                                          }
                                          this.aagA = ((dbh)new dbh().toPb(((JSONObject)localObject).toString()));
                                          continue;
                                          localObject = paramString.opt((String)localObject);
                                          if (!(localObject instanceof JSONObject)) {
                                            continue;
                                          }
                                          this.aagB = ((hq)new hq().toPb(((JSONObject)localObject).toString()));
                                          continue;
                                          this.akkS = ((Integer)paramString.opt((String)localObject)).intValue();
                                          continue;
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
                    }
                  }
                }
              }
            }
          }
        }
      }
      label1028:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bxq
 * JD-Core Version:    0.7.0.1
 */