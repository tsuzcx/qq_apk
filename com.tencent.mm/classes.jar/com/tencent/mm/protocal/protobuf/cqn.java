package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqn
  extends dyl
{
  public int RLe;
  public float ScO;
  public float ScP;
  public int Sxt;
  public String Sxu;
  public String Sxv;
  public int Sxw;
  public int TxW;
  public int TxX;
  public String lWn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89929);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.oE(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.RLe);
      paramVarArgs.i(3, this.ScO);
      paramVarArgs.i(4, this.ScP);
      paramVarArgs.aY(5, this.Sxt);
      if (this.Sxu != null) {
        paramVarArgs.f(6, this.Sxu);
      }
      if (this.Sxv != null) {
        paramVarArgs.f(7, this.Sxv);
      }
      paramVarArgs.aY(8, this.Sxw);
      if (this.lWn != null) {
        paramVarArgs.f(9, this.lWn);
      }
      paramVarArgs.aY(10, this.TxW);
      paramVarArgs.aY(11, this.TxX);
      AppMethodBeat.o(89929);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label786;
      }
    }
    label786:
    for (paramInt = g.a.a.a.oD(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.RLe) + (g.a.a.b.b.a.gL(3) + 4) + (g.a.a.b.b.a.gL(4) + 4) + g.a.a.b.b.a.bM(5, this.Sxt);
      paramInt = i;
      if (this.Sxu != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.Sxu);
      }
      i = paramInt;
      if (this.Sxv != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.Sxv);
      }
      i += g.a.a.b.b.a.bM(8, this.Sxw);
      paramInt = i;
      if (this.lWn != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.lWn);
      }
      i = g.a.a.b.b.a.bM(10, this.TxW);
      int j = g.a.a.b.b.a.bM(11, this.TxX);
      AppMethodBeat.o(89929);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dyl.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dyl.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(89929);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cqn localcqn = (cqn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(89929);
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
            localcqn.BaseRequest = localjg;
            paramInt += 1;
          }
          AppMethodBeat.o(89929);
          return 0;
        case 2: 
          localcqn.RLe = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(89929);
          return 0;
        case 3: 
          localcqn.ScO = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(89929);
          return 0;
        case 4: 
          localcqn.ScP = Float.intBitsToFloat(((g.a.a.a.a)localObject).abFh.AO());
          AppMethodBeat.o(89929);
          return 0;
        case 5: 
          localcqn.Sxt = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(89929);
          return 0;
        case 6: 
          localcqn.Sxu = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(89929);
          return 0;
        case 7: 
          localcqn.Sxv = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(89929);
          return 0;
        case 8: 
          localcqn.Sxw = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(89929);
          return 0;
        case 9: 
          localcqn.lWn = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(89929);
          return 0;
        case 10: 
          localcqn.TxW = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(89929);
          return 0;
        }
        localcqn.TxX = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(89929);
        return 0;
      }
      AppMethodBeat.o(89929);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqn
 * JD-Core Version:    0.7.0.1
 */