package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class oo
  extends ckq
{
  public String CMl;
  public int CMm;
  public int channel;
  public String iaw;
  public int tav;
  public String vBm;
  public String vBp;
  public int vzO;
  public String vzP;
  public String vzQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91370);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.tav);
      paramVarArgs.aR(3, this.channel);
      paramVarArgs.aR(4, this.vzO);
      if (this.CMl != null) {
        paramVarArgs.d(5, this.CMl);
      }
      if (this.vBm != null) {
        paramVarArgs.d(6, this.vBm);
      }
      if (this.vzP != null) {
        paramVarArgs.d(7, this.vzP);
      }
      if (this.vBp != null) {
        paramVarArgs.d(8, this.vBp);
      }
      if (this.iaw != null) {
        paramVarArgs.d(9, this.iaw);
      }
      if (this.vzQ != null) {
        paramVarArgs.d(10, this.vzQ);
      }
      paramVarArgs.aR(11, this.CMm);
      AppMethodBeat.o(91370);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label854;
      }
    }
    label854:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.tav) + f.a.a.b.b.a.bA(3, this.channel) + f.a.a.b.b.a.bA(4, this.vzO);
      paramInt = i;
      if (this.CMl != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CMl);
      }
      i = paramInt;
      if (this.vBm != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.vBm);
      }
      paramInt = i;
      if (this.vzP != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.vzP);
      }
      i = paramInt;
      if (this.vBp != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.vBp);
      }
      paramInt = i;
      if (this.iaw != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.iaw);
      }
      i = paramInt;
      if (this.vzQ != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.vzQ);
      }
      paramInt = f.a.a.b.b.a.bA(11, this.CMm);
      AppMethodBeat.o(91370);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91370);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        oo localoo = (oo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91370);
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
            localoo.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91370);
          return 0;
        case 2: 
          localoo.tav = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91370);
          return 0;
        case 3: 
          localoo.channel = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91370);
          return 0;
        case 4: 
          localoo.vzO = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91370);
          return 0;
        case 5: 
          localoo.CMl = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 6: 
          localoo.vBm = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 7: 
          localoo.vzP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 8: 
          localoo.vBp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 9: 
          localoo.iaw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91370);
          return 0;
        case 10: 
          localoo.vzQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91370);
          return 0;
        }
        localoo.CMm = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91370);
        return 0;
      }
      AppMethodBeat.o(91370);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.oo
 * JD-Core Version:    0.7.0.1
 */