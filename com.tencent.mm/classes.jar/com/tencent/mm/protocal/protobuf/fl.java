package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fl
  extends cvc
{
  public int FwD;
  public int FwE;
  public int FwF;
  public long FwG;
  public int FxD;
  public int FxG;
  public long FxJ;
  public String content;
  public int ozA;
  public int scene;
  public String session_id;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(103199);
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
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      paramVarArgs.aY(5, this.FxJ);
      paramVarArgs.aS(6, this.ozA);
      paramVarArgs.aS(7, this.FxD);
      if (this.title != null) {
        paramVarArgs.d(8, this.title);
      }
      paramVarArgs.aS(9, this.scene);
      paramVarArgs.aS(10, this.FwF);
      paramVarArgs.aS(11, this.FwE);
      paramVarArgs.aS(12, this.FwD);
      if (this.session_id != null) {
        paramVarArgs.d(13, this.session_id);
      }
      paramVarArgs.aY(14, this.FwG);
      paramVarArgs.aS(15, this.FxG);
      AppMethodBeat.o(103199);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label962;
      }
    }
    label962:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.url);
      }
      i = paramInt;
      if (this.content != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.content);
      }
      i = i + f.a.a.b.b.a.p(5, this.FxJ) + f.a.a.b.b.a.bz(6, this.ozA) + f.a.a.b.b.a.bz(7, this.FxD);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.title);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.scene) + f.a.a.b.b.a.bz(10, this.FwF) + f.a.a.b.b.a.bz(11, this.FwE) + f.a.a.b.b.a.bz(12, this.FwD);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.session_id);
      }
      i = f.a.a.b.b.a.p(14, this.FwG);
      int j = f.a.a.b.b.a.bz(15, this.FxG);
      AppMethodBeat.o(103199);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(103199);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fl localfl = (fl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 3: 
        default: 
          AppMethodBeat.o(103199);
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
            localfl.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(103199);
          return 0;
        case 2: 
          localfl.url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 4: 
          localfl.content = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 5: 
          localfl.FxJ = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(103199);
          return 0;
        case 6: 
          localfl.ozA = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103199);
          return 0;
        case 7: 
          localfl.FxD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103199);
          return 0;
        case 8: 
          localfl.title = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 9: 
          localfl.scene = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103199);
          return 0;
        case 10: 
          localfl.FwF = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103199);
          return 0;
        case 11: 
          localfl.FwE = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103199);
          return 0;
        case 12: 
          localfl.FwD = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(103199);
          return 0;
        case 13: 
          localfl.session_id = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(103199);
          return 0;
        case 14: 
          localfl.FwG = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(103199);
          return 0;
        }
        localfl.FxG = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(103199);
        return 0;
      }
      AppMethodBeat.o(103199);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fl
 * JD-Core Version:    0.7.0.1
 */