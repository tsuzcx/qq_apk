package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class amr
  extends com.tencent.mm.bx.a
{
  public LinkedList<aem> Wol;
  public String hAB;
  public String hOG;
  public String mpa;
  public String mps;
  public int scene;
  public String sessionId;
  public String talker;
  public String title;
  public String url;
  
  public amr()
  {
    AppMethodBeat.i(257503);
    this.Wol = new LinkedList();
    AppMethodBeat.o(257503);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257506);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "searchId", this.mpa, false);
      com.tencent.mm.bk.a.a(localJSONObject, "sessionId", this.sessionId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "scene", Integer.valueOf(this.scene), false);
      com.tencent.mm.bk.a.a(localJSONObject, "url", this.url, false);
      com.tencent.mm.bk.a.a(localJSONObject, "requestId", this.hOG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "keyword", this.hAB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "extReqParams", this.Wol, false);
      com.tencent.mm.bk.a.a(localJSONObject, "title", this.title, false);
      com.tencent.mm.bk.a.a(localJSONObject, "talker", this.talker, false);
      com.tencent.mm.bk.a.a(localJSONObject, "toSendText", this.mps, false);
      label126:
      AppMethodBeat.o(257506);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label126;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257511);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.mpa != null) {
        paramVarArgs.g(1, this.mpa);
      }
      if (this.sessionId != null) {
        paramVarArgs.g(2, this.sessionId);
      }
      paramVarArgs.bS(3, this.scene);
      if (this.url != null) {
        paramVarArgs.g(4, this.url);
      }
      if (this.hOG != null) {
        paramVarArgs.g(5, this.hOG);
      }
      if (this.hAB != null) {
        paramVarArgs.g(6, this.hAB);
      }
      paramVarArgs.e(7, 8, this.Wol);
      if (this.title != null) {
        paramVarArgs.g(8, this.title);
      }
      if (this.talker != null) {
        paramVarArgs.g(9, this.talker);
      }
      if (this.mps != null) {
        paramVarArgs.g(10, this.mps);
      }
      AppMethodBeat.o(257511);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mpa == null) {
        break label808;
      }
    }
    label808:
    for (paramInt = i.a.a.b.b.a.h(1, this.mpa) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.sessionId);
      }
      i += i.a.a.b.b.a.cJ(3, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.url);
      }
      i = paramInt;
      if (this.hOG != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.hOG);
      }
      paramInt = i;
      if (this.hAB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.hAB);
      }
      i = paramInt + i.a.a.a.c(7, 8, this.Wol);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.title);
      }
      i = paramInt;
      if (this.talker != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.talker);
      }
      paramInt = i;
      if (this.mps != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.mps);
      }
      AppMethodBeat.o(257511);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Wol.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257511);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        amr localamr = (amr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257511);
          return -1;
        case 1: 
          localamr.mpa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257511);
          return 0;
        case 2: 
          localamr.sessionId = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257511);
          return 0;
        case 3: 
          localamr.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257511);
          return 0;
        case 4: 
          localamr.url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257511);
          return 0;
        case 5: 
          localamr.hOG = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257511);
          return 0;
        case 6: 
          localamr.hAB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257511);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aem localaem = new aem();
            if ((localObject != null) && (localObject.length > 0)) {
              localaem.parseFrom((byte[])localObject);
            }
            localamr.Wol.add(localaem);
            paramInt += 1;
          }
          AppMethodBeat.o(257511);
          return 0;
        case 8: 
          localamr.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257511);
          return 0;
        case 9: 
          localamr.talker = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257511);
          return 0;
        }
        localamr.mps = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257511);
        return 0;
      }
      AppMethodBeat.o(257511);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amr
 * JD-Core Version:    0.7.0.1
 */