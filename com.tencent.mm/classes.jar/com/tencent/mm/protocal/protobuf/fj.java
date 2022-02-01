package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fj
  extends cvc
{
  public int FwD;
  public int FwE;
  public int FwF;
  public String FxH;
  public String hXi;
  public int ozA;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103197);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      if (this.hXi != null) {
        paramVarArgs.d(3, this.hXi);
      }
      if (this.FxH != null) {
        paramVarArgs.d(4, this.FxH);
      }
      paramVarArgs.aS(5, this.scene);
      paramVarArgs.aS(6, this.FwF);
      paramVarArgs.aS(7, this.FwE);
      paramVarArgs.aS(8, this.ozA);
      paramVarArgs.aS(10, this.FwD);
      if (this.session_id != null) {
        paramVarArgs.d(11, this.session_id);
      }
      AppMethodBeat.o(103197);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label778;
      }
    }
    label778:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.hXi != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.hXi);
      }
      paramInt = i;
      if (this.FxH != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FxH);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.scene) + f.a.a.b.b.a.bz(6, this.FwF) + f.a.a.b.b.a.bz(7, this.FwE) + f.a.a.b.b.a.bz(8, this.ozA) + f.a.a.b.b.a.bz(10, this.FwD);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.session_id);
      }
      AppMethodBeat.o(103197);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(103197);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fj localfj = (fj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(103197);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localfj.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103197);
          return 0;
        case 2: 
          localfj.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 3: 
          localfj.hXi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 4: 
          localfj.FxH = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103197);
          return 0;
        case 5: 
          localfj.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103197);
          return 0;
        case 6: 
          localfj.FwF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103197);
          return 0;
        case 7: 
          localfj.FwE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103197);
          return 0;
        case 8: 
          localfj.ozA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103197);
          return 0;
        case 10: 
          localfj.FwD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103197);
          return 0;
        }
        localfj.session_id = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(103197);
        return 0;
      }
      AppMethodBeat.o(103197);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fj
 * JD-Core Version:    0.7.0.1
 */