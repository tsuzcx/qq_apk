package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class chi
  extends com.tencent.mm.bx.a
{
  public int ZkU;
  public int ZkV;
  public int ZkW;
  public b ZkY;
  public czp ZkZ;
  public int aaqg;
  public int aaqh;
  public int aaqi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143973);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZkU);
      paramVarArgs.bS(2, this.ZkV);
      paramVarArgs.bS(3, this.ZkW);
      if (this.ZkY != null) {
        paramVarArgs.d(4, this.ZkY);
      }
      paramVarArgs.bS(5, this.aaqg);
      paramVarArgs.bS(6, this.aaqh);
      paramVarArgs.bS(7, this.aaqi);
      if (this.ZkZ != null)
      {
        paramVarArgs.qD(8, this.ZkZ.computeSize());
        this.ZkZ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZkU) + 0 + i.a.a.b.b.a.cJ(2, this.ZkV) + i.a.a.b.b.a.cJ(3, this.ZkW);
      paramInt = i;
      if (this.ZkY != null) {
        paramInt = i + i.a.a.b.b.a.c(4, this.ZkY);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aaqg) + i.a.a.b.b.a.cJ(6, this.aaqh) + i.a.a.b.b.a.cJ(7, this.aaqi);
      paramInt = i;
      if (this.ZkZ != null) {
        paramInt = i + i.a.a.a.qC(8, this.ZkZ.computeSize());
      }
      AppMethodBeat.o(143973);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      chi localchi = (chi)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143973);
        return -1;
      case 1: 
        localchi.ZkU = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143973);
        return 0;
      case 2: 
        localchi.ZkV = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143973);
        return 0;
      case 3: 
        localchi.ZkW = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143973);
        return 0;
      case 4: 
        localchi.ZkY = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(143973);
        return 0;
      case 5: 
        localchi.aaqg = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143973);
        return 0;
      case 6: 
        localchi.aaqh = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143973);
        return 0;
      case 7: 
        localchi.aaqi = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143973);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        czp localczp = new czp();
        if ((localObject != null) && (localObject.length > 0)) {
          localczp.parseFrom((byte[])localObject);
        }
        localchi.ZkZ = localczp;
        paramInt += 1;
      }
      AppMethodBeat.o(143973);
      return 0;
    }
    AppMethodBeat.o(143973);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chi
 * JD-Core Version:    0.7.0.1
 */