package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djg
  extends cvw
{
  public String FOR;
  public int HQX;
  public int HQY;
  public LinkedList<dji> HQZ;
  public djf HRa;
  public int HRb;
  public LinkedList<djf> HRc;
  public String uvF;
  public String uvG;
  
  public djg()
  {
    AppMethodBeat.i(152697);
    this.HQZ = new LinkedList();
    this.HRc = new LinkedList();
    AppMethodBeat.o(152697);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152698);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HQX);
      if (this.uvG != null) {
        paramVarArgs.d(3, this.uvG);
      }
      if (this.uvF != null) {
        paramVarArgs.d(4, this.uvF);
      }
      if (this.FOR != null) {
        paramVarArgs.d(5, this.FOR);
      }
      paramVarArgs.aS(6, this.HQY);
      paramVarArgs.e(7, 8, this.HQZ);
      if (this.HRa != null)
      {
        paramVarArgs.lJ(8, this.HRa.computeSize());
        this.HRa.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(9, this.HRb);
      paramVarArgs.e(10, 8, this.HRc);
      AppMethodBeat.o(152698);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HQX);
      paramInt = i;
      if (this.uvG != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.uvG);
      }
      i = paramInt;
      if (this.uvF != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.uvF);
      }
      paramInt = i;
      if (this.FOR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FOR);
      }
      i = paramInt + f.a.a.b.b.a.bz(6, this.HQY) + f.a.a.a.c(7, 8, this.HQZ);
      paramInt = i;
      if (this.HRa != null) {
        paramInt = i + f.a.a.a.lI(8, this.HRa.computeSize());
      }
      i = f.a.a.b.b.a.bz(9, this.HRb);
      int j = f.a.a.a.c(10, 8, this.HRc);
      AppMethodBeat.o(152698);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HQZ.clear();
        this.HRc.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djg localdjg = (djg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152698);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 2: 
          localdjg.HQX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152698);
          return 0;
        case 3: 
          localdjg.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 4: 
          localdjg.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 5: 
          localdjg.FOR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(152698);
          return 0;
        case 6: 
          localdjg.HQY = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152698);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dji();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dji)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjg.HQZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new djf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((djf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdjg.HRa = ((djf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152698);
          return 0;
        case 9: 
          localdjg.HRb = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(152698);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new djf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((djf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdjg.HRc.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152698);
        return 0;
      }
      AppMethodBeat.o(152698);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djg
 * JD-Core Version:    0.7.0.1
 */