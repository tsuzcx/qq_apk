package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class tz
  extends ckq
{
  public int CAG;
  public long CCh;
  public String CCi;
  public String COP;
  public String CVJ;
  public String CVK;
  public String sdP;
  public String sdQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32157);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.sdQ != null) {
        paramVarArgs.d(2, this.sdQ);
      }
      if (this.sdP != null) {
        paramVarArgs.d(3, this.sdP);
      }
      paramVarArgs.aG(4, this.CCh);
      if (this.COP != null) {
        paramVarArgs.d(5, this.COP);
      }
      if (this.CVJ != null) {
        paramVarArgs.d(6, this.CVJ);
      }
      paramVarArgs.aR(7, this.CAG);
      if (this.CCi != null) {
        paramVarArgs.d(8, this.CCi);
      }
      if (this.CVK != null) {
        paramVarArgs.d(9, this.CVK);
      }
      AppMethodBeat.o(32157);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label781;
      }
    }
    label781:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.sdQ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.sdQ);
      }
      i = paramInt;
      if (this.sdP != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sdP);
      }
      i += f.a.a.b.b.a.q(4, this.CCh);
      paramInt = i;
      if (this.COP != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.COP);
      }
      i = paramInt;
      if (this.CVJ != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CVJ);
      }
      i += f.a.a.b.b.a.bA(7, this.CAG);
      paramInt = i;
      if (this.CCi != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CCi);
      }
      i = paramInt;
      if (this.CVK != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.CVK);
      }
      AppMethodBeat.o(32157);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(32157);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        tz localtz = (tz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32157);
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
            localtz.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32157);
          return 0;
        case 2: 
          localtz.sdQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32157);
          return 0;
        case 3: 
          localtz.sdP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32157);
          return 0;
        case 4: 
          localtz.CCh = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(32157);
          return 0;
        case 5: 
          localtz.COP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32157);
          return 0;
        case 6: 
          localtz.CVJ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32157);
          return 0;
        case 7: 
          localtz.CAG = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32157);
          return 0;
        case 8: 
          localtz.CCi = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32157);
          return 0;
        }
        localtz.CVK = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32157);
        return 0;
      }
      AppMethodBeat.o(32157);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tz
 * JD-Core Version:    0.7.0.1
 */