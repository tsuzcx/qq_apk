package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dtr
  extends dyl
{
  public String OIl;
  public String ONe;
  public int TZS;
  public String fHb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(174536);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.OIl != null) {
        paramVarArgs.f(2, this.OIl);
      }
      if (this.ONe != null) {
        paramVarArgs.f(3, this.ONe);
      }
      paramVarArgs.aY(4, this.TZS);
      if (this.fHb != null) {
        paramVarArgs.f(5, this.fHb);
      }
      AppMethodBeat.o(174536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label512;
      }
    }
    label512:
    for (int i = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.OIl != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.OIl);
      }
      i = paramInt;
      if (this.ONe != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ONe);
      }
      i += g.a.a.b.b.a.bM(4, this.TZS);
      paramInt = i;
      if (this.fHb != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.fHb);
      }
      AppMethodBeat.o(174536);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(174536);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dtr localdtr = (dtr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(174536);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            jg localjg = new jg();
            if ((localObject != null) && (localObject.length > 0)) {
              localjg.parseFrom((byte[])localObject);
            }
            localdtr.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(174536);
          return 0;
        case 2: 
          localdtr.OIl = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(174536);
          return 0;
        case 3: 
          localdtr.ONe = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(174536);
          return 0;
        case 4: 
          localdtr.TZS = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(174536);
          return 0;
        }
        localdtr.fHb = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(174536);
        return 0;
      }
      AppMethodBeat.o(174536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtr
 * JD-Core Version:    0.7.0.1
 */