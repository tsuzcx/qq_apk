package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class agx
  extends esc
{
  public gol YFI;
  public LinkedList<dof> YFm;
  public etl YFn;
  public String ZhO;
  public String ZhP;
  public etl ZpU;
  public etl ZpX;
  public etl ZpY;
  public int lyF;
  
  public agx()
  {
    AppMethodBeat.i(101799);
    this.YFm = new LinkedList();
    AppMethodBeat.o(101799);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101800);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.ZpU == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.ZpX == null)
      {
        paramVarArgs = new b("Not all required fields were included: PYInitial");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.ZpY == null)
      {
        paramVarArgs = new b("Not all required fields were included: QuanPin");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.YFn == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.YFI == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(101800);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZpU != null)
      {
        paramVarArgs.qD(2, this.ZpU.computeSize());
        this.ZpU.writeFields(paramVarArgs);
      }
      if (this.ZpX != null)
      {
        paramVarArgs.qD(3, this.ZpX.computeSize());
        this.ZpX.writeFields(paramVarArgs);
      }
      if (this.ZpY != null)
      {
        paramVarArgs.qD(4, this.ZpY.computeSize());
        this.ZpY.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.lyF);
      paramVarArgs.e(6, 8, this.YFm);
      if (this.YFn != null)
      {
        paramVarArgs.qD(7, this.YFn.computeSize());
        this.YFn.writeFields(paramVarArgs);
      }
      if (this.YFI != null)
      {
        paramVarArgs.qD(8, this.YFI.computeSize());
        this.YFI.writeFields(paramVarArgs);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(9, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(10, this.ZhP);
      }
      AppMethodBeat.o(101800);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1524;
      }
    }
    label1524:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZpU != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZpU.computeSize());
      }
      i = paramInt;
      if (this.ZpX != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZpX.computeSize());
      }
      paramInt = i;
      if (this.ZpY != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZpY.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.lyF) + i.a.a.a.c(6, 8, this.YFm);
      paramInt = i;
      if (this.YFn != null) {
        paramInt = i + i.a.a.a.qC(7, this.YFn.computeSize());
      }
      i = paramInt;
      if (this.YFI != null) {
        i = paramInt + i.a.a.a.qC(8, this.YFI.computeSize());
      }
      paramInt = i;
      if (this.ZhO != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZhO);
      }
      i = paramInt;
      if (this.ZhP != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ZhP);
      }
      AppMethodBeat.o(101800);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YFm.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.ZpU == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.ZpX == null)
        {
          paramVarArgs = new b("Not all required fields were included: PYInitial");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.ZpY == null)
        {
          paramVarArgs = new b("Not all required fields were included: QuanPin");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.YFn == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        if (this.YFI == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(101800);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101800);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        agx localagx = (agx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101800);
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
            localagx.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localagx.ZpU = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localagx.ZpX = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localagx.ZpY = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 5: 
          localagx.lyF = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(101800);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dof();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dof)localObject2).parseFrom((byte[])localObject1);
            }
            localagx.YFm.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localagx.YFn = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localagx.YFI = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(101800);
          return 0;
        case 9: 
          localagx.ZhO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(101800);
          return 0;
        }
        localagx.ZhP = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(101800);
        return 0;
      }
      AppMethodBeat.o(101800);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agx
 * JD-Core Version:    0.7.0.1
 */