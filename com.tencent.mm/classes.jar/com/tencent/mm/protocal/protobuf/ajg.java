package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ajg
  extends cvc
{
  public float FOA;
  public float FOB;
  public String Ggv;
  public int Ggw;
  public String Ggx;
  public String Ggy;
  public int Ggz;
  public int OpCode;
  public String xbo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32207);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      if (this.Ggv != null) {
        paramVarArgs.d(3, this.Ggv);
      }
      paramVarArgs.z(4, this.FOA);
      paramVarArgs.z(5, this.FOB);
      paramVarArgs.aS(6, this.Ggw);
      if (this.Ggx != null) {
        paramVarArgs.d(7, this.Ggx);
      }
      if (this.Ggy != null) {
        paramVarArgs.d(8, this.Ggy);
      }
      paramVarArgs.aS(9, this.Ggz);
      if (this.xbo != null) {
        paramVarArgs.d(10, this.xbo);
      }
      AppMethodBeat.o(32207);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label792;
      }
    }
    label792:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode);
      paramInt = i;
      if (this.Ggv != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Ggv);
      }
      i = paramInt + f.a.a.b.b.a.alU(4) + f.a.a.b.b.a.alU(5) + f.a.a.b.b.a.bz(6, this.Ggw);
      paramInt = i;
      if (this.Ggx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.Ggx);
      }
      i = paramInt;
      if (this.Ggy != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Ggy);
      }
      i += f.a.a.b.b.a.bz(9, this.Ggz);
      paramInt = i;
      if (this.xbo != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.xbo);
      }
      AppMethodBeat.o(32207);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(32207);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ajg localajg = (ajg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32207);
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
            localajg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32207);
          return 0;
        case 2: 
          localajg.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32207);
          return 0;
        case 3: 
          localajg.Ggv = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 4: 
          localajg.FOA = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(32207);
          return 0;
        case 5: 
          localajg.FOB = Float.intBitsToFloat(((f.a.a.a.a)localObject1).NPN.grz());
          AppMethodBeat.o(32207);
          return 0;
        case 6: 
          localajg.Ggw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32207);
          return 0;
        case 7: 
          localajg.Ggx = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 8: 
          localajg.Ggy = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(32207);
          return 0;
        case 9: 
          localajg.Ggz = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32207);
          return 0;
        }
        localajg.xbo = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(32207);
        return 0;
      }
      AppMethodBeat.o(32207);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajg
 * JD-Core Version:    0.7.0.1
 */