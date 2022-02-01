package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class bi
  extends erp
{
  public String ToB;
  public String ToW;
  public long Tpa;
  public int Tpb;
  public String Trm;
  public String Trn;
  public String Tro;
  public String session_id;
  public String tag;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(289947);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.tag != null) {
        paramVarArgs.g(2, this.tag);
      }
      if (this.ToB != null) {
        paramVarArgs.g(3, this.ToB);
      }
      paramVarArgs.bv(4, this.Tpa);
      if (this.ToW != null) {
        paramVarArgs.g(5, this.ToW);
      }
      paramVarArgs.bS(6, this.Tpb);
      if (this.Trm != null) {
        paramVarArgs.g(7, this.Trm);
      }
      if (this.Trn != null) {
        paramVarArgs.g(8, this.Trn);
      }
      if (this.Tro != null) {
        paramVarArgs.g(9, this.Tro);
      }
      if (this.session_id != null) {
        paramVarArgs.g(10, this.session_id);
      }
      AppMethodBeat.o(289947);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label804;
      }
    }
    label804:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tag != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.tag);
      }
      i = paramInt;
      if (this.ToB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ToB);
      }
      i += i.a.a.b.b.a.q(4, this.Tpa);
      paramInt = i;
      if (this.ToW != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ToW);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.Tpb);
      paramInt = i;
      if (this.Trm != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Trm);
      }
      i = paramInt;
      if (this.Trn != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Trn);
      }
      paramInt = i;
      if (this.Tro != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Tro);
      }
      i = paramInt;
      if (this.session_id != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.session_id);
      }
      AppMethodBeat.o(289947);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(289947);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bi localbi = (bi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(289947);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localbi.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(289947);
          return 0;
        case 2: 
          localbi.tag = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289947);
          return 0;
        case 3: 
          localbi.ToB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289947);
          return 0;
        case 4: 
          localbi.Tpa = ((i.a.a.a.a)localObject).ajGk.aaw();
          AppMethodBeat.o(289947);
          return 0;
        case 5: 
          localbi.ToW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289947);
          return 0;
        case 6: 
          localbi.Tpb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(289947);
          return 0;
        case 7: 
          localbi.Trm = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289947);
          return 0;
        case 8: 
          localbi.Trn = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289947);
          return 0;
        case 9: 
          localbi.Tro = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(289947);
          return 0;
        }
        localbi.session_id = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(289947);
        return 0;
      }
      AppMethodBeat.o(289947);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.bi
 * JD-Core Version:    0.7.0.1
 */