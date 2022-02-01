package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ac
  extends cpx
{
  public String DLA;
  public LinkedList<dv> DLB;
  public int DLC;
  public String DLD;
  public int DLE;
  public String DLF;
  public String DLy;
  public String DLz;
  public int OpCode;
  public String SSID;
  public String URL;
  
  public ac()
  {
    AppMethodBeat.i(32095);
    this.DLB = new LinkedList();
    AppMethodBeat.o(32095);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32096);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.d(2, this.URL);
      }
      if (this.SSID != null) {
        paramVarArgs.d(3, this.SSID);
      }
      if (this.DLy != null) {
        paramVarArgs.d(4, this.DLy);
      }
      if (this.DLz != null) {
        paramVarArgs.d(5, this.DLz);
      }
      if (this.DLA != null) {
        paramVarArgs.d(6, this.DLA);
      }
      paramVarArgs.aR(7, this.OpCode);
      paramVarArgs.e(8, 8, this.DLB);
      paramVarArgs.aR(9, this.DLC);
      if (this.DLD != null) {
        paramVarArgs.d(10, this.DLD);
      }
      paramVarArgs.aR(11, this.DLE);
      if (this.DLF != null) {
        paramVarArgs.d(12, this.DLF);
      }
      AppMethodBeat.o(32096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1032;
      }
    }
    label1032:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.URL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.URL);
      }
      i = paramInt;
      if (this.SSID != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.SSID);
      }
      paramInt = i;
      if (this.DLy != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.DLy);
      }
      i = paramInt;
      if (this.DLz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DLz);
      }
      paramInt = i;
      if (this.DLA != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DLA);
      }
      i = paramInt + f.a.a.b.b.a.bx(7, this.OpCode) + f.a.a.a.c(8, 8, this.DLB) + f.a.a.b.b.a.bx(9, this.DLC);
      paramInt = i;
      if (this.DLD != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DLD);
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.DLE);
      paramInt = i;
      if (this.DLF != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.DLF);
      }
      AppMethodBeat.o(32096);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DLB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(32096);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ac localac = (ac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32096);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localac.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32096);
          return 0;
        case 2: 
          localac.URL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 3: 
          localac.SSID = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 4: 
          localac.DLy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 5: 
          localac.DLz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 6: 
          localac.DLA = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 7: 
          localac.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32096);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localac.DLB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32096);
          return 0;
        case 9: 
          localac.DLC = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32096);
          return 0;
        case 10: 
          localac.DLD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(32096);
          return 0;
        case 11: 
          localac.DLE = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(32096);
          return 0;
        }
        localac.DLF = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(32096);
        return 0;
      }
      AppMethodBeat.o(32096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ac
 * JD-Core Version:    0.7.0.1
 */