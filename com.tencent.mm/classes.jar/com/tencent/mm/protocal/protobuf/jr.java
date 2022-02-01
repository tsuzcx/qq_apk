package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jr
  extends com.tencent.mm.bx.a
{
  public String JFk;
  public String Ocp;
  public int Ocq;
  public int Ocr;
  public String Ocs;
  public String Oct;
  public String Ocu;
  public long Ocx;
  public LinkedList<aoc> YLW;
  public String YLX;
  public String YLY;
  public String hAk;
  
  public jr()
  {
    AppMethodBeat.i(72420);
    this.YLW = new LinkedList();
    AppMethodBeat.o(72420);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72421);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAk != null) {
        paramVarArgs.g(1, this.hAk);
      }
      if (this.JFk != null) {
        paramVarArgs.g(2, this.JFk);
      }
      if (this.Ocp != null) {
        paramVarArgs.g(3, this.Ocp);
      }
      paramVarArgs.bS(4, this.Ocq);
      paramVarArgs.bS(5, this.Ocr);
      paramVarArgs.e(6, 8, this.YLW);
      if (this.Ocs != null) {
        paramVarArgs.g(7, this.Ocs);
      }
      if (this.Oct != null) {
        paramVarArgs.g(8, this.Oct);
      }
      if (this.Ocu != null) {
        paramVarArgs.g(9, this.Ocu);
      }
      if (this.YLX != null) {
        paramVarArgs.g(10, this.YLX);
      }
      if (this.YLY != null) {
        paramVarArgs.g(11, this.YLY);
      }
      paramVarArgs.bv(12, this.Ocx);
      AppMethodBeat.o(72421);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAk == null) {
        break label896;
      }
    }
    label896:
    for (int i = i.a.a.b.b.a.h(1, this.hAk) + 0;; i = 0)
    {
      paramInt = i;
      if (this.JFk != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.JFk);
      }
      i = paramInt;
      if (this.Ocp != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Ocp);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.Ocq) + i.a.a.b.b.a.cJ(5, this.Ocr) + i.a.a.a.c(6, 8, this.YLW);
      paramInt = i;
      if (this.Ocs != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Ocs);
      }
      i = paramInt;
      if (this.Oct != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Oct);
      }
      paramInt = i;
      if (this.Ocu != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Ocu);
      }
      i = paramInt;
      if (this.YLX != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.YLX);
      }
      paramInt = i;
      if (this.YLY != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YLY);
      }
      i = i.a.a.b.b.a.q(12, this.Ocx);
      AppMethodBeat.o(72421);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YLW.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72421);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        jr localjr = (jr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72421);
          return -1;
        case 1: 
          localjr.hAk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 2: 
          localjr.JFk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 3: 
          localjr.Ocp = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 4: 
          localjr.Ocq = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72421);
          return 0;
        case 5: 
          localjr.Ocr = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72421);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aoc localaoc = new aoc();
            if ((localObject != null) && (localObject.length > 0)) {
              localaoc.parseFrom((byte[])localObject);
            }
            localjr.YLW.add(localaoc);
            paramInt += 1;
          }
          AppMethodBeat.o(72421);
          return 0;
        case 7: 
          localjr.Ocs = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 8: 
          localjr.Oct = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 9: 
          localjr.Ocu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 10: 
          localjr.YLX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72421);
          return 0;
        case 11: 
          localjr.YLY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72421);
          return 0;
        }
        localjr.Ocx = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(72421);
        return 0;
      }
      AppMethodBeat.o(72421);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jr
 * JD-Core Version:    0.7.0.1
 */