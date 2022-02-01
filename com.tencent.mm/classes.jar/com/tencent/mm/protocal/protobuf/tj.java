package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tj
  extends com.tencent.mm.bx.a
{
  public String FBS;
  public bpn FQZ;
  public LinkedList<dmo> FRa;
  public int FRb;
  public int FRc;
  public dmo FsP;
  public cwq FsR;
  public String dkR;
  public int state;
  public String wBI;
  
  public tj()
  {
    AppMethodBeat.i(91394);
    this.FRa = new LinkedList();
    AppMethodBeat.o(91394);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91395);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FQZ != null)
      {
        paramVarArgs.lC(1, this.FQZ.computeSize());
        this.FQZ.writeFields(paramVarArgs);
      }
      if (this.FsP != null)
      {
        paramVarArgs.lC(2, this.FsP.computeSize());
        this.FsP.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.FRa);
      if (this.wBI != null) {
        paramVarArgs.d(4, this.wBI);
      }
      if (this.dkR != null) {
        paramVarArgs.d(5, this.dkR);
      }
      if (this.FsR != null)
      {
        paramVarArgs.lC(6, this.FsR.computeSize());
        this.FsR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.state);
      paramVarArgs.aS(8, this.FRb);
      paramVarArgs.aS(9, this.FRc);
      if (this.FBS != null) {
        paramVarArgs.d(10, this.FBS);
      }
      AppMethodBeat.o(91395);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FQZ == null) {
        break label1078;
      }
    }
    label1078:
    for (paramInt = f.a.a.a.lB(1, this.FQZ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FsP != null) {
        i = paramInt + f.a.a.a.lB(2, this.FsP.computeSize());
      }
      i += f.a.a.a.c(3, 8, this.FRa);
      paramInt = i;
      if (this.wBI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wBI);
      }
      i = paramInt;
      if (this.dkR != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.dkR);
      }
      paramInt = i;
      if (this.FsR != null) {
        paramInt = i + f.a.a.a.lB(6, this.FsR.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.state) + f.a.a.b.b.a.bz(8, this.FRb) + f.a.a.b.b.a.bz(9, this.FRc);
      paramInt = i;
      if (this.FBS != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FBS);
      }
      AppMethodBeat.o(91395);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FRa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91395);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tj localtj = (tj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91395);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bpn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bpn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtj.FQZ = ((bpn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtj.FsP = ((dmo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmo();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmo)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtj.FRa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 4: 
          localtj.wBI = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 5: 
          localtj.dkR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91395);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwq();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localtj.FsR = ((cwq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91395);
          return 0;
        case 7: 
          localtj.state = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91395);
          return 0;
        case 8: 
          localtj.FRb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91395);
          return 0;
        case 9: 
          localtj.FRc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91395);
          return 0;
        }
        localtj.FBS = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(91395);
        return 0;
      }
      AppMethodBeat.o(91395);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tj
 * JD-Core Version:    0.7.0.1
 */