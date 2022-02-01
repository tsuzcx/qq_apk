package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bqy
  extends com.tencent.mm.bx.a
{
  public bip ZYT;
  public LinkedList<String> ZYU;
  public LinkedList<String> ZYV;
  public LinkedList<FinderJumpInfo> ZYW;
  public bks ZYX;
  public brc ZYY;
  public btk ZYZ;
  public LinkedList<FinderJumpInfo> akkQ;
  public LinkedList<FinderJumpInfo> jump_info;
  public long object_id;
  
  public bqy()
  {
    AppMethodBeat.i(257500);
    this.ZYU = new LinkedList();
    this.ZYV = new LinkedList();
    this.jump_info = new LinkedList();
    this.ZYW = new LinkedList();
    this.akkQ = new LinkedList();
    AppMethodBeat.o(257500);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257508);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.object_id);
      if (this.ZYT != null)
      {
        paramVarArgs.qD(2, this.ZYT.computeSize());
        this.ZYT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 1, this.ZYU);
      paramVarArgs.e(4, 1, this.ZYV);
      paramVarArgs.e(5, 8, this.jump_info);
      paramVarArgs.e(6, 8, this.ZYW);
      if (this.ZYX != null)
      {
        paramVarArgs.qD(7, this.ZYX.computeSize());
        this.ZYX.writeFields(paramVarArgs);
      }
      if (this.ZYY != null)
      {
        paramVarArgs.qD(8, this.ZYY.computeSize());
        this.ZYY.writeFields(paramVarArgs);
      }
      if (this.ZYZ != null)
      {
        paramVarArgs.qD(9, this.ZYZ.computeSize());
        this.ZYZ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(10, 8, this.akkQ);
      AppMethodBeat.o(257508);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.object_id) + 0;
      paramInt = i;
      if (this.ZYT != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZYT.computeSize());
      }
      i = paramInt + i.a.a.a.c(3, 1, this.ZYU) + i.a.a.a.c(4, 1, this.ZYV) + i.a.a.a.c(5, 8, this.jump_info) + i.a.a.a.c(6, 8, this.ZYW);
      paramInt = i;
      if (this.ZYX != null) {
        paramInt = i + i.a.a.a.qC(7, this.ZYX.computeSize());
      }
      i = paramInt;
      if (this.ZYY != null) {
        i = paramInt + i.a.a.a.qC(8, this.ZYY.computeSize());
      }
      paramInt = i;
      if (this.ZYZ != null) {
        paramInt = i + i.a.a.a.qC(9, this.ZYZ.computeSize());
      }
      i = i.a.a.a.c(10, 8, this.akkQ);
      AppMethodBeat.o(257508);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZYU.clear();
      this.ZYV.clear();
      this.jump_info.clear();
      this.ZYW.clear();
      this.akkQ.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(257508);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      bqy localbqy = (bqy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(257508);
        return -1;
      case 1: 
        localbqy.object_id = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(257508);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bip();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bip)localObject2).parseFrom((byte[])localObject1);
          }
          localbqy.ZYT = ((bip)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257508);
        return 0;
      case 3: 
        localbqy.ZYU.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(257508);
        return 0;
      case 4: 
        localbqy.ZYV.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(257508);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderJumpInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderJumpInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localbqy.jump_info.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257508);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new FinderJumpInfo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((FinderJumpInfo)localObject2).parseFrom((byte[])localObject1);
          }
          localbqy.ZYW.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257508);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new bks();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((bks)localObject2).parseFrom((byte[])localObject1);
          }
          localbqy.ZYX = ((bks)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257508);
        return 0;
      case 8: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new brc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((brc)localObject2).parseFrom((byte[])localObject1);
          }
          localbqy.ZYY = ((brc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257508);
        return 0;
      case 9: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new btk();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((btk)localObject2).parseFrom((byte[])localObject1);
          }
          localbqy.ZYZ = ((btk)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257508);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new FinderJumpInfo();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((FinderJumpInfo)localObject2).parseFrom((byte[])localObject1);
        }
        localbqy.akkQ.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(257508);
      return 0;
    }
    AppMethodBeat.o(257508);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bqy
 * JD-Core Version:    0.7.0.1
 */