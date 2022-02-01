package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fnm
  extends com.tencent.mm.bx.a
{
  public String Md5;
  public String YTj;
  public int Zkv;
  public String aalQ;
  public LinkedList<fnl> abNu;
  public boolean abNv;
  public LinkedList<fno> abNw;
  public String abNx;
  public int crz;
  public int vhJ;
  public int xKa;
  
  public fnm()
  {
    AppMethodBeat.i(6438);
    this.abNu = new LinkedList();
    this.abNw = new LinkedList();
    AppMethodBeat.o(6438);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6439);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vhJ);
      paramVarArgs.bS(2, this.crz);
      if (this.YTj != null) {
        paramVarArgs.g(3, this.YTj);
      }
      if (this.Md5 != null) {
        paramVarArgs.g(4, this.Md5);
      }
      paramVarArgs.bS(5, this.Zkv);
      paramVarArgs.bS(6, this.xKa);
      paramVarArgs.e(7, 8, this.abNu);
      paramVarArgs.di(8, this.abNv);
      if (this.aalQ != null) {
        paramVarArgs.g(9, this.aalQ);
      }
      paramVarArgs.e(10, 8, this.abNw);
      if (this.abNx != null) {
        paramVarArgs.g(11, this.abNx);
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.vhJ) + 0 + i.a.a.b.b.a.cJ(2, this.crz);
      paramInt = i;
      if (this.YTj != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YTj);
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.Md5);
      }
      i = i + i.a.a.b.b.a.cJ(5, this.Zkv) + i.a.a.b.b.a.cJ(6, this.xKa) + i.a.a.a.c(7, 8, this.abNu) + (i.a.a.b.b.a.ko(8) + 1);
      paramInt = i;
      if (this.aalQ != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aalQ);
      }
      i = paramInt + i.a.a.a.c(10, 8, this.abNw);
      paramInt = i;
      if (this.abNx != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.abNx);
      }
      AppMethodBeat.o(6439);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abNu.clear();
      this.abNw.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(6439);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      fnm localfnm = (fnm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(6439);
        return -1;
      case 1: 
        localfnm.vhJ = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(6439);
        return 0;
      case 2: 
        localfnm.crz = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(6439);
        return 0;
      case 3: 
        localfnm.YTj = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 4: 
        localfnm.Md5 = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 5: 
        localfnm.Zkv = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(6439);
        return 0;
      case 6: 
        localfnm.xKa = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(6439);
        return 0;
      case 7: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fnl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fnl)localObject2).parseFrom((byte[])localObject1);
          }
          localfnm.abNu.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      case 8: 
        localfnm.abNv = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(6439);
        return 0;
      case 9: 
        localfnm.aalQ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(6439);
        return 0;
      case 10: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fno();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fno)localObject2).parseFrom((byte[])localObject1);
          }
          localfnm.abNw.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(6439);
        return 0;
      }
      localfnm.abNx = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(6439);
      return 0;
    }
    AppMethodBeat.o(6439);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnm
 * JD-Core Version:    0.7.0.1
 */