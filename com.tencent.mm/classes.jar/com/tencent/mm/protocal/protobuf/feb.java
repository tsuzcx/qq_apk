package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class feb
  extends dyl
{
  public eae RNM;
  public int Svu;
  public long Svv;
  public int TWl;
  public int UDI;
  public int UDJ;
  public int UDK;
  public int UDL;
  public int UDM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115876);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RNM == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(115876);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Svu);
      paramVarArgs.bm(3, this.Svv);
      paramVarArgs.aY(4, this.TWl);
      paramVarArgs.aY(5, this.UDI);
      paramVarArgs.aY(6, this.UDJ);
      paramVarArgs.aY(7, this.UDK);
      paramVarArgs.aY(8, this.UDL);
      paramVarArgs.aY(9, this.UDM);
      if (this.RNM != null)
      {
        paramVarArgs.oE(10, this.RNM.computeSize());
        this.RNM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115876);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label818;
      }
    }
    label818:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.Svu) + g.a.a.b.b.a.p(3, this.Svv) + g.a.a.b.b.a.bM(4, this.TWl) + g.a.a.b.b.a.bM(5, this.UDI) + g.a.a.b.b.a.bM(6, this.UDJ) + g.a.a.b.b.a.bM(7, this.UDK) + g.a.a.b.b.a.bM(8, this.UDL) + g.a.a.b.b.a.bM(9, this.UDM);
      paramInt = i;
      if (this.RNM != null) {
        paramInt = i + g.a.a.a.oD(10, this.RNM.computeSize());
      }
      AppMethodBeat.o(115876);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RNM == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(115876);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115876);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        feb localfeb = (feb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115876);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jg)localObject2).parseFrom((byte[])localObject1);
            }
            localfeb.BaseRequest = ((jg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115876);
          return 0;
        case 2: 
          localfeb.Svu = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115876);
          return 0;
        case 3: 
          localfeb.Svv = ((g.a.a.a.a)localObject1).abFh.AN();
          AppMethodBeat.o(115876);
          return 0;
        case 4: 
          localfeb.TWl = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115876);
          return 0;
        case 5: 
          localfeb.UDI = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115876);
          return 0;
        case 6: 
          localfeb.UDJ = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115876);
          return 0;
        case 7: 
          localfeb.UDK = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115876);
          return 0;
        case 8: 
          localfeb.UDL = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115876);
          return 0;
        case 9: 
          localfeb.UDM = ((g.a.a.a.a)localObject1).abFh.AK();
          AppMethodBeat.o(115876);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eae();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eae)localObject2).dd((byte[])localObject1);
          }
          localfeb.RNM = ((eae)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115876);
        return 0;
      }
      AppMethodBeat.o(115876);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.feb
 * JD-Core Version:    0.7.0.1
 */