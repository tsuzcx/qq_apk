package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class def
  extends esc
{
  public String IKJ;
  public String YDL;
  public String YIU;
  public String aaJH;
  public String aaJI;
  public String aaJJ;
  public String aaJK;
  public int aaJL;
  public ddh aaJx;
  public LinkedList<eul> aans;
  public String pSi;
  
  public def()
  {
    AppMethodBeat.i(123616);
    this.aans = new LinkedList();
    AppMethodBeat.o(123616);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123617);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123617);
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
      paramVarArgs.e(4, 8, this.aans);
      if (this.IKJ != null) {
        paramVarArgs.g(5, this.IKJ);
      }
      if (this.YDL != null) {
        paramVarArgs.g(6, this.YDL);
      }
      if (this.YIU != null) {
        paramVarArgs.g(7, this.YIU);
      }
      if (this.aaJJ != null) {
        paramVarArgs.g(8, this.aaJJ);
      }
      if (this.aaJK != null) {
        paramVarArgs.g(9, this.aaJK);
      }
      paramVarArgs.bS(10, this.aaJL);
      if (this.aaJH != null) {
        paramVarArgs.g(11, this.aaJH);
      }
      if (this.pSi != null) {
        paramVarArgs.g(12, this.pSi);
      }
      AppMethodBeat.o(123617);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1124;
      }
    }
    label1124:
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
      i += i.a.a.a.c(4, 8, this.aans);
      paramInt = i;
      if (this.IKJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.IKJ);
      }
      i = paramInt;
      if (this.YDL != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YDL);
      }
      paramInt = i;
      if (this.YIU != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.YIU);
      }
      i = paramInt;
      if (this.aaJJ != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aaJJ);
      }
      paramInt = i;
      if (this.aaJK != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaJK);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.aaJL);
      paramInt = i;
      if (this.aaJH != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.aaJH);
      }
      i = paramInt;
      if (this.pSi != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.pSi);
      }
      AppMethodBeat.o(123617);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aans.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(123617);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123617);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        def localdef = (def)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123617);
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
            localdef.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
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
            localdef.aaJx = ((ddh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
          return 0;
        case 3: 
          localdef.aaJI = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eul();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eul)localObject2).parseFrom((byte[])localObject1);
            }
            localdef.aans.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123617);
          return 0;
        case 5: 
          localdef.IKJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 6: 
          localdef.YDL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 7: 
          localdef.YIU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 8: 
          localdef.aaJJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 9: 
          localdef.aaJK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123617);
          return 0;
        case 10: 
          localdef.aaJL = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123617);
          return 0;
        case 11: 
          localdef.aaJH = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123617);
          return 0;
        }
        localdef.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(123617);
        return 0;
      }
      AppMethodBeat.o(123617);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.def
 * JD-Core Version:    0.7.0.1
 */