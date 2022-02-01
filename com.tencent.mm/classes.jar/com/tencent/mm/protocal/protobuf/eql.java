package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eql
  extends com.tencent.mm.cd.a
{
  public LinkedList<aci> Pye;
  public int UsU;
  public String fIY;
  public String fwe;
  public String jQi;
  public int scene;
  public String sessionId;
  public String talker;
  public String title;
  public String url;
  public int xbJ;
  
  public eql()
  {
    AppMethodBeat.i(222458);
    this.Pye = new LinkedList();
    AppMethodBeat.o(222458);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(222504);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jQi != null) {
        paramVarArgs.f(1, this.jQi);
      }
      if (this.sessionId != null) {
        paramVarArgs.f(2, this.sessionId);
      }
      paramVarArgs.aY(3, this.scene);
      if (this.url != null) {
        paramVarArgs.f(4, this.url);
      }
      if (this.fIY != null) {
        paramVarArgs.f(5, this.fIY);
      }
      if (this.fwe != null) {
        paramVarArgs.f(6, this.fwe);
      }
      paramVarArgs.e(7, 8, this.Pye);
      if (this.title != null) {
        paramVarArgs.f(8, this.title);
      }
      if (this.talker != null) {
        paramVarArgs.f(9, this.talker);
      }
      paramVarArgs.aY(10, this.xbJ);
      paramVarArgs.aY(11, this.UsU);
      AppMethodBeat.o(222504);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jQi == null) {
        break label840;
      }
    }
    label840:
    for (paramInt = g.a.a.b.b.a.g(1, this.jQi) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.sessionId != null) {
        i = paramInt + g.a.a.b.b.a.g(2, this.sessionId);
      }
      i += g.a.a.b.b.a.bM(3, this.scene);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.url);
      }
      i = paramInt;
      if (this.fIY != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.fIY);
      }
      paramInt = i;
      if (this.fwe != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.fwe);
      }
      i = paramInt + g.a.a.a.c(7, 8, this.Pye);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.title);
      }
      i = paramInt;
      if (this.talker != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.talker);
      }
      paramInt = g.a.a.b.b.a.bM(10, this.xbJ);
      int j = g.a.a.b.b.a.bM(11, this.UsU);
      AppMethodBeat.o(222504);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Pye.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(222504);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        eql localeql = (eql)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(222504);
          return -1;
        case 1: 
          localeql.jQi = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222504);
          return 0;
        case 2: 
          localeql.sessionId = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222504);
          return 0;
        case 3: 
          localeql.scene = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(222504);
          return 0;
        case 4: 
          localeql.url = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222504);
          return 0;
        case 5: 
          localeql.fIY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222504);
          return 0;
        case 6: 
          localeql.fwe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222504);
          return 0;
        case 7: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aci localaci = new aci();
            if ((localObject != null) && (localObject.length > 0)) {
              localaci.parseFrom((byte[])localObject);
            }
            localeql.Pye.add(localaci);
            paramInt += 1;
          }
          AppMethodBeat.o(222504);
          return 0;
        case 8: 
          localeql.title = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222504);
          return 0;
        case 9: 
          localeql.talker = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(222504);
          return 0;
        case 10: 
          localeql.xbJ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(222504);
          return 0;
        }
        localeql.UsU = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(222504);
        return 0;
      }
      AppMethodBeat.o(222504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eql
 * JD-Core Version:    0.7.0.1
 */