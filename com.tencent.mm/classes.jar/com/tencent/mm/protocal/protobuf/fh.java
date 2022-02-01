package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fh
  extends cvc
{
  public int FwD;
  public int FwE;
  public int FwF;
  public int FxD;
  public String FxE;
  public int FxF;
  public int FxG;
  public int ozA;
  public int scene;
  public String session_id;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(177339);
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
      paramVarArgs.aS(5, this.FxD);
      if (this.FxE != null) {
        paramVarArgs.d(6, this.FxE);
      }
      paramVarArgs.aS(7, this.FxF);
      paramVarArgs.aS(8, this.ozA);
      paramVarArgs.aS(9, this.FxG);
      paramVarArgs.aS(10, this.scene);
      paramVarArgs.aS(11, this.FwF);
      paramVarArgs.aS(12, this.FwE);
      paramVarArgs.aS(13, this.FwD);
      if (this.session_id != null) {
        paramVarArgs.d(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label858;
      }
    }
    label858:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i += f.a.a.b.b.a.bz(5, this.FxD);
      paramInt = i;
      if (this.FxE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FxE);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.FxF) + f.a.a.b.b.a.bz(8, this.ozA) + f.a.a.b.b.a.bz(9, this.FxG) + f.a.a.b.b.a.bz(10, this.scene) + f.a.a.b.b.a.bz(11, this.FwF) + f.a.a.b.b.a.bz(12, this.FwE) + f.a.a.b.b.a.bz(13, this.FwD);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.session_id);
      }
      AppMethodBeat.o(177339);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(177339);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fh localfh = (fh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        case 4: 
        default: 
          AppMethodBeat.o(177339);
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
            localfh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(177339);
          return 0;
        case 2: 
          localfh.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 5: 
          localfh.FxD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 6: 
          localfh.FxE = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(177339);
          return 0;
        case 7: 
          localfh.FxF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 8: 
          localfh.ozA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 9: 
          localfh.FxG = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 10: 
          localfh.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 11: 
          localfh.FwF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 12: 
          localfh.FwE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(177339);
          return 0;
        case 13: 
          localfh.FwD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(177339);
          return 0;
        }
        localfh.session_id = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(177339);
        return 0;
      }
      AppMethodBeat.o(177339);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fh
 * JD-Core Version:    0.7.0.1
 */