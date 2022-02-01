package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bz
  extends com.tencent.mm.bx.a
{
  public String IIe;
  public String IKJ;
  public String YDJ;
  public String YDK;
  public String YDL;
  public String YDM;
  public String YDN;
  public String YDO;
  public gns YDP;
  public String YDQ;
  public String muA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152478);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.muA != null) {
        paramVarArgs.g(1, this.muA);
      }
      if (this.YDJ != null) {
        paramVarArgs.g(2, this.YDJ);
      }
      if (this.YDK != null) {
        paramVarArgs.g(3, this.YDK);
      }
      if (this.IIe != null) {
        paramVarArgs.g(4, this.IIe);
      }
      if (this.IKJ != null) {
        paramVarArgs.g(5, this.IKJ);
      }
      if (this.YDL != null) {
        paramVarArgs.g(6, this.YDL);
      }
      if (this.YDM != null) {
        paramVarArgs.g(7, this.YDM);
      }
      if (this.YDN != null) {
        paramVarArgs.g(8, this.YDN);
      }
      if (this.YDO != null) {
        paramVarArgs.g(9, this.YDO);
      }
      if (this.YDP != null)
      {
        paramVarArgs.qD(10, this.YDP.computeSize());
        this.YDP.writeFields(paramVarArgs);
      }
      if (this.YDQ != null) {
        paramVarArgs.g(11, this.YDQ);
      }
      AppMethodBeat.o(152478);
      return 0;
    }
    if (paramInt == 1) {
      if (this.muA == null) {
        break label896;
      }
    }
    label896:
    for (int i = i.a.a.b.b.a.h(1, this.muA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YDJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YDJ);
      }
      i = paramInt;
      if (this.YDK != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YDK);
      }
      paramInt = i;
      if (this.IIe != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IIe);
      }
      i = paramInt;
      if (this.IKJ != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IKJ);
      }
      paramInt = i;
      if (this.YDL != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YDL);
      }
      i = paramInt;
      if (this.YDM != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YDM);
      }
      paramInt = i;
      if (this.YDN != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YDN);
      }
      i = paramInt;
      if (this.YDO != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YDO);
      }
      paramInt = i;
      if (this.YDP != null) {
        paramInt = i + i.a.a.a.qC(10, this.YDP.computeSize());
      }
      i = paramInt;
      if (this.YDQ != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.YDQ);
      }
      AppMethodBeat.o(152478);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152478);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bz localbz = (bz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152478);
          return -1;
        case 1: 
          localbz.muA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 2: 
          localbz.YDJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 3: 
          localbz.YDK = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 4: 
          localbz.IIe = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 5: 
          localbz.IKJ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 6: 
          localbz.YDL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 7: 
          localbz.YDM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 8: 
          localbz.YDN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 9: 
          localbz.YDO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(152478);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gns localgns = new gns();
            if ((localObject != null) && (localObject.length > 0)) {
              localgns.parseFrom((byte[])localObject);
            }
            localbz.YDP = localgns;
            paramInt += 1;
          }
          AppMethodBeat.o(152478);
          return 0;
        }
        localbz.YDQ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(152478);
        return 0;
      }
      AppMethodBeat.o(152478);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bz
 * JD-Core Version:    0.7.0.1
 */