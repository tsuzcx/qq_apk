package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class hl
  extends com.tencent.mm.bx.a
{
  public String IGU;
  public String YIQ;
  public hm YIR;
  public String crB;
  public String hAP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125712);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YIR == null)
      {
        paramVarArgs = new b("Not all required fields were included: ArtisIcon");
        AppMethodBeat.o(125712);
        throw paramVarArgs;
      }
      if (this.IGU != null) {
        paramVarArgs.g(1, this.IGU);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.YIQ != null) {
        paramVarArgs.g(3, this.YIQ);
      }
      if (this.crB != null) {
        paramVarArgs.g(4, this.crB);
      }
      if (this.YIR != null)
      {
        paramVarArgs.qD(5, this.YIR.computeSize());
        this.YIR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(125712);
      return 0;
    }
    if (paramInt == 1) {
      if (this.IGU == null) {
        break label572;
      }
    }
    label572:
    for (int i = i.a.a.b.b.a.h(1, this.IGU) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.YIQ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YIQ);
      }
      paramInt = i;
      if (this.crB != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.crB);
      }
      i = paramInt;
      if (this.YIR != null) {
        i = paramInt + i.a.a.a.qC(5, this.YIR.computeSize());
      }
      AppMethodBeat.o(125712);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YIR == null)
        {
          paramVarArgs = new b("Not all required fields were included: ArtisIcon");
          AppMethodBeat.o(125712);
          throw paramVarArgs;
        }
        AppMethodBeat.o(125712);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        hl localhl = (hl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125712);
          return -1;
        case 1: 
          localhl.IGU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 2: 
          localhl.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 3: 
          localhl.YIQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125712);
          return 0;
        case 4: 
          localhl.crB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(125712);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          hm localhm = new hm();
          if ((localObject != null) && (localObject.length > 0)) {
            localhm.parseFrom((byte[])localObject);
          }
          localhl.YIR = localhm;
          paramInt += 1;
        }
        AppMethodBeat.o(125712);
        return 0;
      }
      AppMethodBeat.o(125712);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hl
 * JD-Core Version:    0.7.0.1
 */