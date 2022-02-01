package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class hx
  extends com.tencent.mm.cd.a
{
  public int RNq;
  public dnn RNr;
  public String appid;
  public String token;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153260);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      paramVarArgs.aY(2, this.RNq);
      if (this.RNr != null)
      {
        paramVarArgs.oE(3, this.RNr.computeSize());
        this.RNr.writeFields(paramVarArgs);
      }
      if (this.token != null) {
        paramVarArgs.f(4, this.token);
      }
      if (this.appid != null) {
        paramVarArgs.f(5, this.appid);
      }
      AppMethodBeat.o(153260);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label512;
      }
    }
    label512:
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RNq);
      paramInt = i;
      if (this.RNr != null) {
        paramInt = i + g.a.a.a.oD(3, this.RNr.computeSize());
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.token);
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.appid);
      }
      AppMethodBeat.o(153260);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(153260);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        hx localhx = (hx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153260);
          return -1;
        case 1: 
          localhx.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153260);
          return 0;
        case 2: 
          localhx.RNq = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(153260);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dnn localdnn = new dnn();
            if ((localObject != null) && (localObject.length > 0)) {
              localdnn.parseFrom((byte[])localObject);
            }
            localhx.RNr = localdnn;
            paramInt += 1;
          }
          AppMethodBeat.o(153260);
          return 0;
        case 4: 
          localhx.token = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(153260);
          return 0;
        }
        localhx.appid = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(153260);
        return 0;
      }
      AppMethodBeat.o(153260);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hx
 * JD-Core Version:    0.7.0.1
 */