package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class se
  extends ckq
{
  public String CTN;
  public String CTO;
  public String CxW;
  public String CxX;
  public int channel;
  public int tav;
  public String vBi;
  public String vBj;
  public int vzO;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91403);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CxW != null) {
        paramVarArgs.d(2, this.CxW);
      }
      if (this.CxX != null) {
        paramVarArgs.d(3, this.CxX);
      }
      paramVarArgs.aR(4, this.tav);
      if (this.vBj != null) {
        paramVarArgs.d(5, this.vBj);
      }
      if (this.vBi != null) {
        paramVarArgs.d(6, this.vBi);
      }
      paramVarArgs.aR(7, this.channel);
      paramVarArgs.aR(8, this.vzO);
      if (this.CTN != null) {
        paramVarArgs.d(9, this.CTN);
      }
      if (this.CTO != null) {
        paramVarArgs.d(10, this.CTO);
      }
      AppMethodBeat.o(91403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label810;
      }
    }
    label810:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CxW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CxW);
      }
      i = paramInt;
      if (this.CxX != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CxX);
      }
      i += f.a.a.b.b.a.bA(4, this.tav);
      paramInt = i;
      if (this.vBj != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.vBj);
      }
      i = paramInt;
      if (this.vBi != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.vBi);
      }
      i = i + f.a.a.b.b.a.bA(7, this.channel) + f.a.a.b.b.a.bA(8, this.vzO);
      paramInt = i;
      if (this.CTN != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CTN);
      }
      i = paramInt;
      if (this.CTO != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CTO);
      }
      AppMethodBeat.o(91403);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        se localse = (se)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91403);
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
            localse.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91403);
          return 0;
        case 2: 
          localse.CxW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 3: 
          localse.CxX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 4: 
          localse.tav = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91403);
          return 0;
        case 5: 
          localse.vBj = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 6: 
          localse.vBi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91403);
          return 0;
        case 7: 
          localse.channel = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91403);
          return 0;
        case 8: 
          localse.vzO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91403);
          return 0;
        case 9: 
          localse.CTN = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91403);
          return 0;
        }
        localse.CTO = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91403);
        return 0;
      }
      AppMethodBeat.o(91403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.se
 * JD-Core Version:    0.7.0.1
 */