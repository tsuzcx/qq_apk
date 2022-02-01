package com.tencent.mm.protocal.protobuf;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public class btw
  extends com.tencent.mm.bx.a
{
  public String ZYN;
  public LinkedList<bxq> aabA;
  public int aabB;
  public boolean aabC;
  public long aabD;
  public b aabz;
  public long feedId;
  public String internal_feedback_url;
  public int priority;
  public int start_time;
  public int type;
  public int wso;
  
  public btw()
  {
    AppMethodBeat.i(184209);
    this.aabA = new LinkedList();
    AppMethodBeat.o(184209);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184210);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.priority);
      paramVarArgs.bS(2, this.type);
      if (this.aabz != null) {
        paramVarArgs.d(3, this.aabz);
      }
      paramVarArgs.e(4, 8, this.aabA);
      if (this.ZYN != null) {
        paramVarArgs.g(5, this.ZYN);
      }
      paramVarArgs.bS(6, this.wso);
      paramVarArgs.bS(7, this.start_time);
      paramVarArgs.bS(8, this.aabB);
      paramVarArgs.di(9, this.aabC);
      if (this.internal_feedback_url != null) {
        paramVarArgs.g(10, this.internal_feedback_url);
      }
      paramVarArgs.bv(100, this.feedId);
      paramVarArgs.bv(101, this.aabD);
      AppMethodBeat.o(184210);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.priority) + 0 + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.aabz != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.aabz);
      }
      i = paramInt + i.a.a.a.c(4, 8, this.aabA);
      paramInt = i;
      if (this.ZYN != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZYN);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.wso) + i.a.a.b.b.a.cJ(7, this.start_time) + i.a.a.b.b.a.cJ(8, this.aabB) + (i.a.a.b.b.a.ko(9) + 1);
      paramInt = i;
      if (this.internal_feedback_url != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.internal_feedback_url);
      }
      i = i.a.a.b.b.a.q(100, this.feedId);
      int j = i.a.a.b.b.a.q(101, this.aabD);
      AppMethodBeat.o(184210);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aabA.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(184210);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      btw localbtw = (btw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184210);
        return -1;
      case 1: 
        localbtw.priority = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(184210);
        return 0;
      case 2: 
        localbtw.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(184210);
        return 0;
      case 3: 
        localbtw.aabz = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(184210);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bxq localbxq = new bxq();
          if ((localObject != null) && (localObject.length > 0)) {
            localbxq.parseFrom((byte[])localObject);
          }
          localbtw.aabA.add(localbxq);
          paramInt += 1;
        }
        AppMethodBeat.o(184210);
        return 0;
      case 5: 
        localbtw.ZYN = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(184210);
        return 0;
      case 6: 
        localbtw.wso = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(184210);
        return 0;
      case 7: 
        localbtw.start_time = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(184210);
        return 0;
      case 8: 
        localbtw.aabB = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(184210);
        return 0;
      case 9: 
        localbtw.aabC = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(184210);
        return 0;
      case 10: 
        localbtw.internal_feedback_url = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(184210);
        return 0;
      case 100: 
        localbtw.feedId = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(184210);
        return 0;
      }
      localbtw.aabD = ((i.a.a.a.a)localObject).ajGk.aaw();
      AppMethodBeat.o(184210);
      return 0;
    }
    AppMethodBeat.o(184210);
    return -1;
  }
  
  public final JSONObject toJSON()
  {
    AppMethodBeat.i(259342);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "priority", Integer.valueOf(this.priority), true);
      com.tencent.mm.bk.a.a(localJSONObject, "type", Integer.valueOf(this.type), true);
      com.tencent.mm.bk.a.a(localJSONObject, "extInfo", this.aabz, true);
      com.tencent.mm.bk.a.a(localJSONObject, "show_infos", this.aabA, true);
      com.tencent.mm.bk.a.a(localJSONObject, "tips_id", this.ZYN, true);
      com.tencent.mm.bk.a.a(localJSONObject, "expire_time", Integer.valueOf(this.wso), true);
      com.tencent.mm.bk.a.a(localJSONObject, "start_time", Integer.valueOf(this.start_time), true);
      com.tencent.mm.bk.a.a(localJSONObject, "ignore_display_tab_type", Integer.valueOf(this.aabB), true);
      com.tencent.mm.bk.a.a(localJSONObject, "ignore_valid", Boolean.valueOf(this.aabC), true);
      com.tencent.mm.bk.a.a(localJSONObject, "internal_feedback_url", this.internal_feedback_url, true);
      com.tencent.mm.bk.a.a(localJSONObject, "feedId", Long.valueOf(this.feedId), true);
      com.tencent.mm.bk.a.a(localJSONObject, "localFlag", Long.valueOf(this.aabD), true);
      label169:
      AppMethodBeat.o(259342);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label169;
    }
  }
  
  public com.tencent.mm.bx.a toPb(String paramString)
  {
    AppMethodBeat.i(259349);
    if ((paramString == null) || ("" == paramString))
    {
      AppMethodBeat.o(259349);
      return this;
    }
    label676:
    label743:
    label748:
    for (;;)
    {
      Object localObject1;
      try
      {
        paramString = new JSONObject(paramString);
        Iterator localIterator = paramString.keys();
        if (localIterator.hasNext())
        {
          localObject1 = (String)localIterator.next();
          i = -1;
        }
        switch (((String)localObject1).hashCode())
        {
        case -1165461084: 
          this.priority = ((Integer)paramString.opt((String)localObject1)).intValue();
          continue;
          if (!((String)localObject1).equals("priority")) {
            break label676;
          }
        }
      }
      catch (Exception paramString)
      {
        Log.printErrStackTrace("FinderRedDotCtrlInfo", paramString, "", new Object[0]);
        AppMethodBeat.o(259349);
        return this;
      }
      int i = 0;
      break label676;
      if (((String)localObject1).equals("type"))
      {
        i = 1;
        break label676;
        if (((String)localObject1).equals("extInfo"))
        {
          i = 2;
          break label676;
          if (((String)localObject1).equals("show_infos"))
          {
            i = 3;
            break label676;
            if (((String)localObject1).equals("tips_id"))
            {
              i = 4;
              break label676;
              if (((String)localObject1).equals("expire_time"))
              {
                i = 5;
                break label676;
                if (((String)localObject1).equals("start_time"))
                {
                  i = 6;
                  break label676;
                  if (((String)localObject1).equals("ignore_display_tab_type"))
                  {
                    i = 7;
                    break label676;
                    if (((String)localObject1).equals("ignore_valid"))
                    {
                      i = 8;
                      break label676;
                      if (((String)localObject1).equals("internal_feedback_url"))
                      {
                        i = 9;
                        break label676;
                        if (((String)localObject1).equals("feedId"))
                        {
                          i = 10;
                          break label676;
                          if (((String)localObject1).equals("localFlag"))
                          {
                            i = 11;
                            break label676;
                            this.type = ((Integer)paramString.opt((String)localObject1)).intValue();
                            continue;
                            localObject1 = paramString.opt((String)localObject1);
                            if (!(localObject1 instanceof String)) {
                              continue;
                            }
                            this.aabz = b.cX(Base64.decode((String)localObject1, 0));
                            continue;
                            localObject1 = paramString.opt((String)localObject1);
                            if (!(localObject1 instanceof JSONArray)) {
                              continue;
                            }
                            localObject1 = (JSONArray)localObject1;
                            i = 0;
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
      for (;;)
      {
        if (i >= ((JSONArray)localObject1).length()) {
          break label748;
        }
        Object localObject2 = ((JSONArray)localObject1).get(i);
        if ((localObject2 instanceof JSONObject))
        {
          this.aabA.add((bxq)new bxq().toPb(((JSONObject)localObject2).toString()));
          break label743;
          this.ZYN = ((String)paramString.opt((String)localObject1));
          break;
          this.wso = ((Integer)paramString.opt((String)localObject1)).intValue();
          break;
          this.start_time = ((Integer)paramString.opt((String)localObject1)).intValue();
          break;
          this.aabB = ((Integer)paramString.opt((String)localObject1)).intValue();
          break;
          this.aabC = ((Boolean)paramString.opt((String)localObject1)).booleanValue();
          break;
          this.internal_feedback_url = ((String)paramString.opt((String)localObject1));
          break;
          this.feedId = ((Long)paramString.opt((String)localObject1)).longValue();
          break;
          this.aabD = ((Long)paramString.opt((String)localObject1)).longValue();
          break;
          switch (i)
          {
          }
          break;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.btw
 * JD-Core Version:    0.7.0.1
 */