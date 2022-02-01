package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class doz
  extends dyl
{
  public String CRQ;
  public int Svu;
  public long Svv;
  public long TVZ;
  public int TWa;
  public String TWb;
  public long TWc;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32372);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.bm(3, this.Svv);
      if (this.CRQ != null) {
        paramVarArgs.f(4, this.CRQ);
      }
      paramVarArgs.bm(5, this.TVZ);
      paramVarArgs.aY(6, this.TWa);
      if (this.TWb != null) {
        paramVarArgs.f(7, this.TWb);
      }
      paramVarArgs.bm(8, this.TWc);
      AppMethodBeat.o(32372);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label646;
      }
    }
    label646:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Svu) + g.a.a.b.b.a.p(3, this.Svv);
      paramInt = i;
      if (this.CRQ != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.CRQ);
      }
      i = paramInt + g.a.a.b.b.a.p(5, this.TVZ) + g.a.a.b.b.a.bM(6, this.TWa);
      paramInt = i;
      if (this.TWb != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.TWb);
      }
      i = g.a.a.b.b.a.p(8, this.TWc);
      AppMethodBeat.o(32372);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(32372);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        doz localdoz = (doz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32372);
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
            localdoz.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(32372);
          return 0;
        case 2: 
          localdoz.Svu = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32372);
          return 0;
        case 3: 
          localdoz.Svv = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32372);
          return 0;
        case 4: 
          localdoz.CRQ = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32372);
          return 0;
        case 5: 
          localdoz.TVZ = ((g.a.a.a.a)localObject).abFh.AN();
          AppMethodBeat.o(32372);
          return 0;
        case 6: 
          localdoz.TWa = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32372);
          return 0;
        case 7: 
          localdoz.TWb = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32372);
          return 0;
        }
        localdoz.TWc = ((g.a.a.a.a)localObject).abFh.AN();
        AppMethodBeat.o(32372);
        return 0;
      }
      AppMethodBeat.o(32372);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doz
 * JD-Core Version:    0.7.0.1
 */