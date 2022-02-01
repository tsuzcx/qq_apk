package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class coq
  extends ckq
{
  public int CLL;
  public String CRC;
  public String CYV;
  public String EiG;
  public int dep;
  public String dlB;
  public int scene;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91683);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CYV != null) {
        paramVarArgs.d(2, this.CYV);
      }
      if (this.dlB != null) {
        paramVarArgs.d(3, this.dlB);
      }
      if (this.url != null) {
        paramVarArgs.d(4, this.url);
      }
      if (this.EiG != null) {
        paramVarArgs.d(5, this.EiG);
      }
      paramVarArgs.aR(6, this.scene);
      paramVarArgs.aR(7, this.dep);
      if (this.CRC != null) {
        paramVarArgs.d(8, this.CRC);
      }
      paramVarArgs.aR(9, this.CLL);
      AppMethodBeat.o(91683);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label750;
      }
    }
    label750:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CYV != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.CYV);
      }
      i = paramInt;
      if (this.dlB != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dlB);
      }
      paramInt = i;
      if (this.url != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.url);
      }
      i = paramInt;
      if (this.EiG != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EiG);
      }
      i = i + f.a.a.b.b.a.bA(6, this.scene) + f.a.a.b.b.a.bA(7, this.dep);
      paramInt = i;
      if (this.CRC != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.CRC);
      }
      i = f.a.a.b.b.a.bA(9, this.CLL);
      AppMethodBeat.o(91683);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(91683);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        coq localcoq = (coq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91683);
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
            localcoq.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91683);
          return 0;
        case 2: 
          localcoq.CYV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 3: 
          localcoq.dlB = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 4: 
          localcoq.url = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 5: 
          localcoq.EiG = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91683);
          return 0;
        case 6: 
          localcoq.scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91683);
          return 0;
        case 7: 
          localcoq.dep = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(91683);
          return 0;
        case 8: 
          localcoq.CRC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(91683);
          return 0;
        }
        localcoq.CLL = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(91683);
        return 0;
      }
      AppMethodBeat.o(91683);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.coq
 * JD-Core Version:    0.7.0.1
 */