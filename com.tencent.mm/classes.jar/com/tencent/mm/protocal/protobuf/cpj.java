package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cpj
  extends ckq
{
  public String CyF;
  public String DZr;
  public String EiW;
  public String EiX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196738);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.DZr != null) {
        paramVarArgs.d(2, this.DZr);
      }
      if (this.EiW != null) {
        paramVarArgs.d(3, this.EiW);
      }
      if (this.EiX != null) {
        paramVarArgs.d(4, this.EiX);
      }
      if (this.CyF != null) {
        paramVarArgs.d(5, this.CyF);
      }
      AppMethodBeat.o(196738);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label550;
      }
    }
    label550:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DZr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.DZr);
      }
      i = paramInt;
      if (this.EiW != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EiW);
      }
      paramInt = i;
      if (this.EiX != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EiX);
      }
      i = paramInt;
      if (this.CyF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CyF);
      }
      AppMethodBeat.o(196738);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(196738);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cpj localcpj = (cpj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196738);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcpj.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196738);
          return 0;
        case 2: 
          localcpj.DZr = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(196738);
          return 0;
        case 3: 
          localcpj.EiW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(196738);
          return 0;
        case 4: 
          localcpj.EiX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(196738);
          return 0;
        }
        localcpj.CyF = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(196738);
        return 0;
      }
      AppMethodBeat.o(196738);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpj
 * JD-Core Version:    0.7.0.1
 */