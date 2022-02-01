package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class ded
  extends esc
{
  public String YIU;
  public String aaJH;
  public String aaJI;
  public String aaJJ;
  public String aaJK;
  public int aaJL;
  public ddh aaJx;
  public String pSi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123613);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123613);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaJx != null)
      {
        paramVarArgs.qD(2, this.aaJx.computeSize());
        this.aaJx.writeFields(paramVarArgs);
      }
      if (this.aaJI != null) {
        paramVarArgs.g(3, this.aaJI);
      }
      if (this.YIU != null) {
        paramVarArgs.g(4, this.YIU);
      }
      if (this.aaJJ != null) {
        paramVarArgs.g(5, this.aaJJ);
      }
      if (this.aaJK != null) {
        paramVarArgs.g(6, this.aaJK);
      }
      paramVarArgs.bS(7, this.aaJL);
      if (this.aaJH != null) {
        paramVarArgs.g(8, this.aaJH);
      }
      if (this.pSi != null) {
        paramVarArgs.g(9, this.pSi);
      }
      AppMethodBeat.o(123613);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label878;
      }
    }
    label878:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaJx != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaJx.computeSize());
      }
      i = paramInt;
      if (this.aaJI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaJI);
      }
      paramInt = i;
      if (this.YIU != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YIU);
      }
      i = paramInt;
      if (this.aaJJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aaJJ);
      }
      paramInt = i;
      if (this.aaJK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaJK);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.aaJL);
      paramInt = i;
      if (this.aaJH != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aaJH);
      }
      i = paramInt;
      if (this.pSi != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.pSi);
      }
      AppMethodBeat.o(123613);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123613);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123613);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ded localded = (ded)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123613);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localded.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ddh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ddh)localObject2).parseFrom((byte[])localObject1);
            }
            localded.aaJx = ((ddh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123613);
          return 0;
        case 3: 
          localded.aaJI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 4: 
          localded.YIU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 5: 
          localded.aaJJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 6: 
          localded.aaJK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123613);
          return 0;
        case 7: 
          localded.aaJL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123613);
          return 0;
        case 8: 
          localded.aaJH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123613);
          return 0;
        }
        localded.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(123613);
        return 0;
      }
      AppMethodBeat.o(123613);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ded
 * JD-Core Version:    0.7.0.1
 */