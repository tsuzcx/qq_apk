package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class acz
  extends com.tencent.mm.bx.a
{
  public String COT;
  public String CxC;
  public SKBuiltinBuffer_t DdC;
  public String DdD;
  public String DdE;
  public String DdF;
  public int DdG;
  public String MD5;
  public int mBH;
  public String sdP;
  public int uKQ;
  public int uKR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DdC == null)
      {
        paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(109446);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aR(2, this.uKR);
      paramVarArgs.aR(3, this.uKQ);
      if (this.DdC != null)
      {
        paramVarArgs.kX(4, this.DdC.computeSize());
        this.DdC.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(5, this.mBH);
      if (this.sdP != null) {
        paramVarArgs.d(6, this.sdP);
      }
      if (this.DdD != null) {
        paramVarArgs.d(7, this.DdD);
      }
      if (this.DdE != null) {
        paramVarArgs.d(8, this.DdE);
      }
      if (this.DdF != null) {
        paramVarArgs.d(9, this.DdF);
      }
      if (this.CxC != null) {
        paramVarArgs.d(10, this.CxC);
      }
      paramVarArgs.aR(11, this.DdG);
      if (this.COT != null) {
        paramVarArgs.d(12, this.COT);
      }
      AppMethodBeat.o(109446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label966;
      }
    }
    label966:
    for (paramInt = f.a.a.b.b.a.e(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.uKR) + f.a.a.b.b.a.bA(3, this.uKQ);
      paramInt = i;
      if (this.DdC != null) {
        paramInt = i + f.a.a.a.kW(4, this.DdC.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bA(5, this.mBH);
      paramInt = i;
      if (this.sdP != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.sdP);
      }
      i = paramInt;
      if (this.DdD != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DdD);
      }
      paramInt = i;
      if (this.DdE != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DdE);
      }
      i = paramInt;
      if (this.DdF != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.DdF);
      }
      paramInt = i;
      if (this.CxC != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CxC);
      }
      i = paramInt + f.a.a.b.b.a.bA(11, this.DdG);
      paramInt = i;
      if (this.COT != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.COT);
      }
      AppMethodBeat.o(109446);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.DdC == null)
        {
          paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(109446);
          throw paramVarArgs;
        }
        AppMethodBeat.o(109446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acz localacz = (acz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(109446);
          return -1;
        case 1: 
          localacz.MD5 = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 2: 
          localacz.uKR = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(109446);
          return 0;
        case 3: 
          localacz.uKQ = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(109446);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacz.DdC = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(109446);
          return 0;
        case 5: 
          localacz.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(109446);
          return 0;
        case 6: 
          localacz.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 7: 
          localacz.DdD = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 8: 
          localacz.DdE = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 9: 
          localacz.DdF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 10: 
          localacz.CxC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 11: 
          localacz.DdG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(109446);
          return 0;
        }
        localacz.COT = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(109446);
        return 0;
      }
      AppMethodBeat.o(109446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acz
 * JD-Core Version:    0.7.0.1
 */