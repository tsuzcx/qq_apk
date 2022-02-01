package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aci
  extends com.tencent.mm.bx.a
{
  public dfc VXQ;
  public dfc VXR;
  public LinkedList<dfp> ZkL;
  public String igN;
  public String title;
  
  public aci()
  {
    AppMethodBeat.i(72460);
    this.ZkL = new LinkedList();
    AppMethodBeat.o(72460);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72461);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.igN != null) {
        paramVarArgs.g(2, this.igN);
      }
      paramVarArgs.e(3, 8, this.ZkL);
      if (this.VXQ != null)
      {
        paramVarArgs.qD(4, this.VXQ.computeSize());
        this.VXQ.writeFields(paramVarArgs);
      }
      if (this.VXR != null)
      {
        paramVarArgs.qD(5, this.VXR.computeSize());
        this.VXR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label656;
      }
    }
    label656:
    for (paramInt = i.a.a.b.b.a.h(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.igN != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.igN);
      }
      i += i.a.a.a.c(3, 8, this.ZkL);
      paramInt = i;
      if (this.VXQ != null) {
        paramInt = i + i.a.a.a.qC(4, this.VXQ.computeSize());
      }
      i = paramInt;
      if (this.VXR != null) {
        i = paramInt + i.a.a.a.qC(5, this.VXR.computeSize());
      }
      AppMethodBeat.o(72461);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZkL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aci localaci = (aci)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72461);
          return -1;
        case 1: 
          localaci.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 2: 
          localaci.igN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72461);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfp)localObject2).parseFrom((byte[])localObject1);
            }
            localaci.ZkL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dfc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dfc)localObject2).parseFrom((byte[])localObject1);
            }
            localaci.VXQ = ((dfc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72461);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dfc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dfc)localObject2).parseFrom((byte[])localObject1);
          }
          localaci.VXR = ((dfc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72461);
        return 0;
      }
      AppMethodBeat.o(72461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aci
 * JD-Core Version:    0.7.0.1
 */