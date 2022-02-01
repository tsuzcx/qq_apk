package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class due
  extends ckq
{
  public LinkedList<String> EID;
  public boolean EIE;
  public String EIF;
  public boolean EIG;
  public String EtQ;
  public String dlB;
  
  public due()
  {
    AppMethodBeat.i(153313);
    this.EID = new LinkedList();
    AppMethodBeat.o(153313);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153314);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dlB != null) {
        paramVarArgs.d(2, this.dlB);
      }
      paramVarArgs.e(3, 1, this.EID);
      paramVarArgs.bg(4, this.EIE);
      if (this.EIF != null) {
        paramVarArgs.d(5, this.EIF);
      }
      paramVarArgs.bg(6, this.EIG);
      if (this.EtQ != null) {
        paramVarArgs.d(7, this.EtQ);
      }
      AppMethodBeat.o(153314);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label634;
      }
    }
    label634:
    for (paramInt = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.dlB);
      }
      i = i + f.a.a.a.c(3, 1, this.EID) + (f.a.a.b.b.a.fY(4) + 1);
      paramInt = i;
      if (this.EIF != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EIF);
      }
      i = paramInt + (f.a.a.b.b.a.fY(6) + 1);
      paramInt = i;
      if (this.EtQ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.EtQ);
      }
      AppMethodBeat.o(153314);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EID.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(153314);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        due localdue = (due)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153314);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdue.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153314);
          return 0;
        case 2: 
          localdue.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 3: 
          localdue.EID.add(((f.a.a.a.a)localObject1).KhF.readString());
          AppMethodBeat.o(153314);
          return 0;
        case 4: 
          localdue.EIE = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153314);
          return 0;
        case 5: 
          localdue.EIF = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(153314);
          return 0;
        case 6: 
          localdue.EIG = ((f.a.a.a.a)localObject1).KhF.fHu();
          AppMethodBeat.o(153314);
          return 0;
        }
        localdue.EtQ = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(153314);
        return 0;
      }
      AppMethodBeat.o(153314);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.due
 * JD-Core Version:    0.7.0.1
 */