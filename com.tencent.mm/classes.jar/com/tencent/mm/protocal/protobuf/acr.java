package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class acr
  extends ckq
{
  public String CBQ;
  public int CCB;
  public SKBuiltinBuffer_t CFU;
  public String CFx;
  public String CGf;
  public String Ddl;
  public String Ddm;
  public int Ddn;
  public String oXs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155402);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CFU == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(155402);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CFU != null)
      {
        paramVarArgs.kX(2, this.CFU.computeSize());
        this.CFU.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.CCB);
      if (this.CFx != null) {
        paramVarArgs.d(4, this.CFx);
      }
      if (this.oXs != null) {
        paramVarArgs.d(5, this.oXs);
      }
      if (this.CGf != null) {
        paramVarArgs.d(6, this.CGf);
      }
      if (this.Ddl != null) {
        paramVarArgs.d(7, this.Ddl);
      }
      if (this.CBQ != null) {
        paramVarArgs.d(8, this.CBQ);
      }
      if (this.Ddm != null) {
        paramVarArgs.d(9, this.Ddm);
      }
      paramVarArgs.aR(10, this.Ddn);
      AppMethodBeat.o(155402);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.CFU != null) {
        i = paramInt + f.a.a.a.kW(2, this.CFU.computeSize());
      }
      i += f.a.a.b.b.a.bA(3, this.CCB);
      paramInt = i;
      if (this.CFx != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CFx);
      }
      i = paramInt;
      if (this.oXs != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.oXs);
      }
      paramInt = i;
      if (this.CGf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CGf);
      }
      i = paramInt;
      if (this.Ddl != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Ddl);
      }
      paramInt = i;
      if (this.CBQ != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CBQ);
      }
      i = paramInt;
      if (this.Ddm != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Ddm);
      }
      paramInt = f.a.a.b.b.a.bA(10, this.Ddn);
      AppMethodBeat.o(155402);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CFU == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(155402);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155402);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acr localacr = (acr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155402);
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
            localacr.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155402);
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
            localacr.CFU = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155402);
          return 0;
        case 3: 
          localacr.CCB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(155402);
          return 0;
        case 4: 
          localacr.CFx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 5: 
          localacr.oXs = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 6: 
          localacr.CGf = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 7: 
          localacr.Ddl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 8: 
          localacr.CBQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155402);
          return 0;
        case 9: 
          localacr.Ddm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(155402);
          return 0;
        }
        localacr.Ddn = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(155402);
        return 0;
      }
      AppMethodBeat.o(155402);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acr
 * JD-Core Version:    0.7.0.1
 */