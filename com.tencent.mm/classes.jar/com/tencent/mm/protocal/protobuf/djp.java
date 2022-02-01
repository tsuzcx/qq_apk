package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class djp
  extends ckq
{
  public String DYr;
  public String DYs;
  public int DYt;
  public String DYu;
  public SKBuiltinBuffer_t Ezs;
  public int Ezt;
  public int Ezu;
  public String Ezv;
  public String ProductID;
  public int upf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91722);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ezs == null)
      {
        paramVarArgs = new b("Not all required fields were included: Receipt");
        AppMethodBeat.o(91722);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Ezs != null)
      {
        paramVarArgs.kX(2, this.Ezs.computeSize());
        this.Ezs.writeFields(paramVarArgs);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(3, this.ProductID);
      }
      paramVarArgs.aR(4, this.Ezt);
      paramVarArgs.aR(5, this.upf);
      if (this.DYr != null) {
        paramVarArgs.d(6, this.DYr);
      }
      if (this.DYs != null) {
        paramVarArgs.d(7, this.DYs);
      }
      if (this.DYu != null) {
        paramVarArgs.d(8, this.DYu);
      }
      paramVarArgs.aR(9, this.Ezu);
      if (this.Ezv != null) {
        paramVarArgs.d(10, this.Ezv);
      }
      paramVarArgs.aR(11, this.DYt);
      AppMethodBeat.o(91722);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label998;
      }
    }
    label998:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Ezs != null) {
        paramInt = i + f.a.a.a.kW(2, this.Ezs.computeSize());
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ProductID);
      }
      i = i + f.a.a.b.b.a.bA(4, this.Ezt) + f.a.a.b.b.a.bA(5, this.upf);
      paramInt = i;
      if (this.DYr != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DYr);
      }
      i = paramInt;
      if (this.DYs != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.DYs);
      }
      paramInt = i;
      if (this.DYu != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DYu);
      }
      i = paramInt + f.a.a.b.b.a.bA(9, this.Ezu);
      paramInt = i;
      if (this.Ezv != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Ezv);
      }
      i = f.a.a.b.b.a.bA(11, this.DYt);
      AppMethodBeat.o(91722);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Ezs == null)
        {
          paramVarArgs = new b("Not all required fields were included: Receipt");
          AppMethodBeat.o(91722);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91722);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djp localdjp = (djp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91722);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjp.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjp.Ezs = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91722);
          return 0;
        case 3: 
          localdjp.ProductID = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 4: 
          localdjp.Ezt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91722);
          return 0;
        case 5: 
          localdjp.upf = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91722);
          return 0;
        case 6: 
          localdjp.DYr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 7: 
          localdjp.DYs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 8: 
          localdjp.DYu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91722);
          return 0;
        case 9: 
          localdjp.Ezu = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91722);
          return 0;
        case 10: 
          localdjp.Ezv = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91722);
          return 0;
        }
        localdjp.DYt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91722);
        return 0;
      }
      AppMethodBeat.o(91722);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djp
 * JD-Core Version:    0.7.0.1
 */