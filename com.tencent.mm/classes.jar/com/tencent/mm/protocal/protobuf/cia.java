package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cia
  extends esc
{
  public long aaqE;
  public boolean aaqF;
  public long aaqG;
  public LinkedList<vx> aaqH;
  public agm aaqJ;
  public agm aaqK;
  public String title;
  public String wuA;
  
  public cia()
  {
    AppMethodBeat.i(258865);
    this.aaqH = new LinkedList();
    AppMethodBeat.o(258865);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258872);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(258872);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.aaqE);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      paramVarArgs.di(4, this.aaqF);
      paramVarArgs.bv(5, this.aaqG);
      if (this.title != null) {
        paramVarArgs.g(6, this.title);
      }
      paramVarArgs.e(7, 8, this.aaqH);
      if (this.aaqJ != null)
      {
        paramVarArgs.qD(8, this.aaqJ.computeSize());
        this.aaqJ.writeFields(paramVarArgs);
      }
      if (this.aaqK != null)
      {
        paramVarArgs.qD(9, this.aaqK.computeSize());
        this.aaqK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258872);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label974;
      }
    }
    label974:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.aaqE);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + (i.a.a.b.b.a.ko(4) + 1) + i.a.a.b.b.a.q(5, this.aaqG);
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.title);
      }
      i = paramInt + i.a.a.a.c(7, 8, this.aaqH);
      paramInt = i;
      if (this.aaqJ != null) {
        paramInt = i + i.a.a.a.qC(8, this.aaqJ.computeSize());
      }
      i = paramInt;
      if (this.aaqK != null) {
        i = paramInt + i.a.a.a.qC(9, this.aaqK.computeSize());
      }
      AppMethodBeat.o(258872);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaqH.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(258872);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258872);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cia localcia = (cia)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258872);
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
            localcia.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258872);
          return 0;
        case 2: 
          localcia.aaqE = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258872);
          return 0;
        case 3: 
          localcia.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258872);
          return 0;
        case 4: 
          localcia.aaqF = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(258872);
          return 0;
        case 5: 
          localcia.aaqG = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258872);
          return 0;
        case 6: 
          localcia.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258872);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new vx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((vx)localObject2).parseFrom((byte[])localObject1);
            }
            localcia.aaqH.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258872);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new agm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((agm)localObject2).parseFrom((byte[])localObject1);
            }
            localcia.aaqJ = ((agm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258872);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new agm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((agm)localObject2).parseFrom((byte[])localObject1);
          }
          localcia.aaqK = ((agm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258872);
        return 0;
      }
      AppMethodBeat.o(258872);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cia
 * JD-Core Version:    0.7.0.1
 */