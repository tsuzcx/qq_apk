package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class ctu
  extends cld
{
  public String DLH;
  public int ElA;
  public int ElB;
  public b ElC;
  public String Eln;
  public String Elo;
  public String Elp;
  public int Elz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117928);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Eln != null) {
        paramVarArgs.d(2, this.Eln);
      }
      paramVarArgs.aR(3, this.Elz);
      paramVarArgs.aR(4, this.ElA);
      if (this.Elo != null) {
        paramVarArgs.d(5, this.Elo);
      }
      if (this.Elp != null) {
        paramVarArgs.d(6, this.Elp);
      }
      paramVarArgs.aR(7, this.ElB);
      if (this.DLH != null) {
        paramVarArgs.d(8, this.DLH);
      }
      if (this.ElC != null) {
        paramVarArgs.c(9, this.ElC);
      }
      AppMethodBeat.o(117928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Eln != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Eln);
      }
      i = i + f.a.a.b.b.a.bA(3, this.Elz) + f.a.a.b.b.a.bA(4, this.ElA);
      paramInt = i;
      if (this.Elo != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Elo);
      }
      i = paramInt;
      if (this.Elp != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Elp);
      }
      i += f.a.a.b.b.a.bA(7, this.ElB);
      paramInt = i;
      if (this.DLH != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.DLH);
      }
      i = paramInt;
      if (this.ElC != null) {
        i = paramInt + f.a.a.b.b.a.b(9, this.ElC);
      }
      AppMethodBeat.o(117928);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(117928);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ctu localctu = (ctu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117928);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localctu.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117928);
          return 0;
        case 2: 
          localctu.Eln = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 3: 
          localctu.Elz = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117928);
          return 0;
        case 4: 
          localctu.ElA = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117928);
          return 0;
        case 5: 
          localctu.Elo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 6: 
          localctu.Elp = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117928);
          return 0;
        case 7: 
          localctu.ElB = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(117928);
          return 0;
        case 8: 
          localctu.DLH = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(117928);
          return 0;
        }
        localctu.ElC = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(117928);
        return 0;
      }
      AppMethodBeat.o(117928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctu
 * JD-Core Version:    0.7.0.1
 */