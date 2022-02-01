package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mu
  extends erp
{
  public int YKH;
  public String YNT;
  public String YNU;
  public String YNV;
  public String YNW;
  public String YNX;
  public String YNY;
  public String YNZ;
  public int beD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155394);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YKH);
      paramVarArgs.bS(3, this.beD);
      if (this.YNT != null) {
        paramVarArgs.g(4, this.YNT);
      }
      if (this.YNU != null) {
        paramVarArgs.g(5, this.YNU);
      }
      if (this.YNV != null) {
        paramVarArgs.g(6, this.YNV);
      }
      if (this.YNW != null) {
        paramVarArgs.g(7, this.YNW);
      }
      if (this.YNX != null) {
        paramVarArgs.g(8, this.YNX);
      }
      if (this.YNY != null) {
        paramVarArgs.g(9, this.YNY);
      }
      if (this.YNZ != null) {
        paramVarArgs.g(10, this.YNZ);
      }
      AppMethodBeat.o(155394);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label800;
      }
    }
    label800:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YKH) + i.a.a.b.b.a.cJ(3, this.beD);
      paramInt = i;
      if (this.YNT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YNT);
      }
      i = paramInt;
      if (this.YNU != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YNU);
      }
      paramInt = i;
      if (this.YNV != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YNV);
      }
      i = paramInt;
      if (this.YNW != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YNW);
      }
      paramInt = i;
      if (this.YNX != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YNX);
      }
      i = paramInt;
      if (this.YNY != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YNY);
      }
      paramInt = i;
      if (this.YNZ != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YNZ);
      }
      AppMethodBeat.o(155394);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155394);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        mu localmu = (mu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155394);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localmu.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(155394);
          return 0;
        case 2: 
          localmu.YKH = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(155394);
          return 0;
        case 3: 
          localmu.beD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(155394);
          return 0;
        case 4: 
          localmu.YNT = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 5: 
          localmu.YNU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 6: 
          localmu.YNV = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 7: 
          localmu.YNW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 8: 
          localmu.YNX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155394);
          return 0;
        case 9: 
          localmu.YNY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(155394);
          return 0;
        }
        localmu.YNZ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(155394);
        return 0;
      }
      AppMethodBeat.o(155394);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mu
 * JD-Core Version:    0.7.0.1
 */