package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abl
  extends erp
{
  public String ZjX;
  public LinkedList<fbn> ZjY;
  public LinkedList<fbp> ZjZ;
  public LinkedList<fbm> Zka;
  public LinkedList<fbl> Zkb;
  public LinkedList<fbo> Zkc;
  public int vhJ;
  
  public abl()
  {
    AppMethodBeat.i(32163);
    this.ZjY = new LinkedList();
    this.ZjZ = new LinkedList();
    this.Zka = new LinkedList();
    this.Zkb = new LinkedList();
    this.Zkc = new LinkedList();
    AppMethodBeat.o(32163);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32164);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.vhJ);
      if (this.ZjX != null) {
        paramVarArgs.g(3, this.ZjX);
      }
      paramVarArgs.e(4, 8, this.ZjY);
      paramVarArgs.e(5, 8, this.ZjZ);
      paramVarArgs.e(6, 8, this.Zka);
      paramVarArgs.e(7, 8, this.Zkb);
      paramVarArgs.e(8, 8, this.Zkc);
      AppMethodBeat.o(32164);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1004;
      }
    }
    label1004:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.vhJ);
      paramInt = i;
      if (this.ZjX != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZjX);
      }
      i = i.a.a.a.c(4, 8, this.ZjY);
      int j = i.a.a.a.c(5, 8, this.ZjZ);
      int k = i.a.a.a.c(6, 8, this.Zka);
      int m = i.a.a.a.c(7, 8, this.Zkb);
      int n = i.a.a.a.c(8, 8, this.Zkc);
      AppMethodBeat.o(32164);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZjY.clear();
        this.ZjZ.clear();
        this.Zka.clear();
        this.Zkb.clear();
        this.Zkc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32164);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        abl localabl = (abl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32164);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localabl.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 2: 
          localabl.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32164);
          return 0;
        case 3: 
          localabl.ZjX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32164);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbn)localObject2).parseFrom((byte[])localObject1);
            }
            localabl.ZjY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbp)localObject2).parseFrom((byte[])localObject1);
            }
            localabl.ZjZ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbm)localObject2).parseFrom((byte[])localObject1);
            }
            localabl.Zka.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fbl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fbl)localObject2).parseFrom((byte[])localObject1);
            }
            localabl.Zkb.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32164);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fbo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fbo)localObject2).parseFrom((byte[])localObject1);
          }
          localabl.Zkc.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32164);
        return 0;
      }
      AppMethodBeat.o(32164);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abl
 * JD-Core Version:    0.7.0.1
 */