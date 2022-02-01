package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cic
  extends com.tencent.mm.bx.a
{
  public String Edu;
  public LinkedList<cyg> Edv;
  public String Edw;
  public String Edx;
  public String Edy;
  public cia Edz;
  public String description;
  public String gGQ;
  public String gGR;
  public String gGS;
  public int ntg;
  public String title;
  
  public cic()
  {
    AppMethodBeat.i(168759);
    this.Edv = new LinkedList();
    AppMethodBeat.o(168759);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.gGR != null) {
        paramVarArgs.d(2, this.gGR);
      }
      if (this.gGS != null) {
        paramVarArgs.d(3, this.gGS);
      }
      if (this.description != null) {
        paramVarArgs.d(4, this.description);
      }
      if (this.Edu != null) {
        paramVarArgs.d(9, this.Edu);
      }
      paramVarArgs.e(10, 8, this.Edv);
      paramVarArgs.aR(11, this.ntg);
      if (this.Edw != null) {
        paramVarArgs.d(12, this.Edw);
      }
      if (this.Edx != null) {
        paramVarArgs.d(13, this.Edx);
      }
      if (this.Edy != null) {
        paramVarArgs.d(14, this.Edy);
      }
      if (this.gGQ != null) {
        paramVarArgs.d(15, this.gGQ);
      }
      if (this.Edz != null)
      {
        paramVarArgs.kX(16, this.Edz.computeSize());
        this.Edz.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168760);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label1066;
      }
    }
    label1066:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.gGR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.gGR);
      }
      i = paramInt;
      if (this.gGS != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.gGS);
      }
      paramInt = i;
      if (this.description != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.description);
      }
      i = paramInt;
      if (this.Edu != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.Edu);
      }
      i = i + f.a.a.a.c(10, 8, this.Edv) + f.a.a.b.b.a.bA(11, this.ntg);
      paramInt = i;
      if (this.Edw != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Edw);
      }
      i = paramInt;
      if (this.Edx != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.Edx);
      }
      paramInt = i;
      if (this.Edy != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Edy);
      }
      i = paramInt;
      if (this.gGQ != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.gGQ);
      }
      paramInt = i;
      if (this.Edz != null) {
        paramInt = i + f.a.a.a.kW(16, this.Edz.computeSize());
      }
      AppMethodBeat.o(168760);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Edv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(168760);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cic localcic = (cic)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(168760);
          return -1;
        case 1: 
          localcic.title = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 2: 
          localcic.gGR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 3: 
          localcic.gGS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 4: 
          localcic.description = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 9: 
          localcic.Edu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyg();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcic.Edv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168760);
          return 0;
        case 11: 
          localcic.ntg = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(168760);
          return 0;
        case 12: 
          localcic.Edw = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 13: 
          localcic.Edx = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 14: 
          localcic.Edy = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168760);
          return 0;
        case 15: 
          localcic.gGQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(168760);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cia();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cia)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcic.Edz = ((cia)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168760);
        return 0;
      }
      AppMethodBeat.o(168760);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cic
 * JD-Core Version:    0.7.0.1
 */