package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnu
  extends ckq
{
  public int CRt;
  public long DLa;
  public long DLb;
  public long DLc;
  public int offset;
  public String query;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169915);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.DLa);
      paramVarArgs.aG(3, this.DLb);
      if (this.query != null) {
        paramVarArgs.d(4, this.query);
      }
      paramVarArgs.aR(5, this.offset);
      paramVarArgs.aR(6, this.CRt);
      paramVarArgs.aG(7, this.DLc);
      AppMethodBeat.o(169915);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.DLa) + f.a.a.b.b.a.q(3, this.DLb);
      paramInt = i;
      if (this.query != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.query);
      }
      i = f.a.a.b.b.a.bA(5, this.offset);
      int j = f.a.a.b.b.a.bA(6, this.CRt);
      int k = f.a.a.b.b.a.q(7, this.DLc);
      AppMethodBeat.o(169915);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(169915);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnu localbnu = (bnu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169915);
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
            localbnu.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169915);
          return 0;
        case 2: 
          localbnu.DLa = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169915);
          return 0;
        case 3: 
          localbnu.DLb = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(169915);
          return 0;
        case 4: 
          localbnu.query = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(169915);
          return 0;
        case 5: 
          localbnu.offset = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169915);
          return 0;
        case 6: 
          localbnu.CRt = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(169915);
          return 0;
        }
        localbnu.DLc = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(169915);
        return 0;
      }
      AppMethodBeat.o(169915);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnu
 * JD-Core Version:    0.7.0.1
 */