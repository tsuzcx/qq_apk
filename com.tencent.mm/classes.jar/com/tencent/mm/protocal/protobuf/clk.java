package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clk
  extends cvp
{
  public String FrA;
  public String FrB;
  public String GXz;
  public String HeA;
  public String HeB;
  public String Hey;
  public String Hez;
  public String content;
  public boolean oAm;
  public String ozC;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114055);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FrA != null) {
        paramVarArgs.d(2, this.FrA);
      }
      if (this.FrB != null) {
        paramVarArgs.d(3, this.FrB);
      }
      paramVarArgs.aS(4, this.status);
      if (this.content != null) {
        paramVarArgs.d(5, this.content);
      }
      if (this.ozC != null) {
        paramVarArgs.d(6, this.ozC);
      }
      if (this.GXz != null) {
        paramVarArgs.d(7, this.GXz);
      }
      paramVarArgs.bt(8, this.oAm);
      if (this.Hey != null) {
        paramVarArgs.d(9, this.Hey);
      }
      if (this.Hez != null) {
        paramVarArgs.d(10, this.Hez);
      }
      if (this.HeA != null) {
        paramVarArgs.d(11, this.HeA);
      }
      if (this.HeB != null) {
        paramVarArgs.d(12, this.HeB);
      }
      AppMethodBeat.o(114055);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label950;
      }
    }
    label950:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FrA != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FrA);
      }
      i = paramInt;
      if (this.FrB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.FrB);
      }
      i += f.a.a.b.b.a.bz(4, this.status);
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.content);
      }
      i = paramInt;
      if (this.ozC != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ozC);
      }
      paramInt = i;
      if (this.GXz != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.GXz);
      }
      i = paramInt + f.a.a.b.b.a.alV(8);
      paramInt = i;
      if (this.Hey != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Hey);
      }
      i = paramInt;
      if (this.Hez != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.Hez);
      }
      paramInt = i;
      if (this.HeA != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HeA);
      }
      i = paramInt;
      if (this.HeB != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HeB);
      }
      AppMethodBeat.o(114055);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(114055);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        clk localclk = (clk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114055);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localclk.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114055);
          return 0;
        case 2: 
          localclk.FrA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 3: 
          localclk.FrB = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 4: 
          localclk.status = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114055);
          return 0;
        case 5: 
          localclk.content = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 6: 
          localclk.ozC = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 7: 
          localclk.GXz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 8: 
          localclk.oAm = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(114055);
          return 0;
        case 9: 
          localclk.Hey = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 10: 
          localclk.Hez = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114055);
          return 0;
        case 11: 
          localclk.HeA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114055);
          return 0;
        }
        localclk.HeB = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(114055);
        return 0;
      }
      AppMethodBeat.o(114055);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clk
 * JD-Core Version:    0.7.0.1
 */