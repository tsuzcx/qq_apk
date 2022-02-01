package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class agh
  extends com.tencent.mm.bx.a
{
  public String FOL;
  public String Fvn;
  public SKBuiltinBuffer_t Gel;
  public String Gem;
  public String Gen;
  public String Geo;
  public int Gep;
  public String MD5;
  public int nEf;
  public String uki;
  public int xcK;
  public int xcL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gel == null)
      {
        paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(109446);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aS(2, this.xcL);
      paramVarArgs.aS(3, this.xcK);
      if (this.Gel != null)
      {
        paramVarArgs.lC(4, this.Gel.computeSize());
        this.Gel.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.nEf);
      if (this.uki != null) {
        paramVarArgs.d(6, this.uki);
      }
      if (this.Gem != null) {
        paramVarArgs.d(7, this.Gem);
      }
      if (this.Gen != null) {
        paramVarArgs.d(8, this.Gen);
      }
      if (this.Geo != null) {
        paramVarArgs.d(9, this.Geo);
      }
      if (this.Fvn != null) {
        paramVarArgs.d(10, this.Fvn);
      }
      paramVarArgs.aS(11, this.Gep);
      if (this.FOL != null) {
        paramVarArgs.d(12, this.FOL);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xcL) + f.a.a.b.b.a.bz(3, this.xcK);
      paramInt = i;
      if (this.Gel != null) {
        paramInt = i + f.a.a.a.lB(4, this.Gel.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.nEf);
      paramInt = i;
      if (this.uki != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uki);
      }
      i = paramInt;
      if (this.Gem != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Gem);
      }
      paramInt = i;
      if (this.Gen != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Gen);
      }
      i = paramInt;
      if (this.Geo != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Geo);
      }
      paramInt = i;
      if (this.Fvn != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Fvn);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.Gep);
      paramInt = i;
      if (this.FOL != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FOL);
      }
      AppMethodBeat.o(109446);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Gel == null)
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
        agh localagh = (agh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(109446);
          return -1;
        case 1: 
          localagh.MD5 = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 2: 
          localagh.xcL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(109446);
          return 0;
        case 3: 
          localagh.xcK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(109446);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagh.Gel = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(109446);
          return 0;
        case 5: 
          localagh.nEf = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(109446);
          return 0;
        case 6: 
          localagh.uki = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 7: 
          localagh.Gem = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 8: 
          localagh.Gen = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 9: 
          localagh.Geo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 10: 
          localagh.Fvn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 11: 
          localagh.Gep = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(109446);
          return 0;
        }
        localagh.FOL = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(109446);
        return 0;
      }
      AppMethodBeat.o(109446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agh
 * JD-Core Version:    0.7.0.1
 */